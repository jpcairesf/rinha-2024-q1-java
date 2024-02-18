package com.rinhadebackend.rinha2024q1java.service;

import com.rinhadebackend.rinha2024q1java.domain.Cliente;
import com.rinhadebackend.rinha2024q1java.domain.Transacao;
import com.rinhadebackend.rinha2024q1java.model.ExtratoResponse;
import com.rinhadebackend.rinha2024q1java.model.ExtratoSaldoResponse;
import com.rinhadebackend.rinha2024q1java.model.ExtratoTransacaoResponse;
import com.rinhadebackend.rinha2024q1java.model.TransacaoRequest;
import com.rinhadebackend.rinha2024q1java.model.TransacaoResponse;
import com.rinhadebackend.rinha2024q1java.repository.ClienteRepository;
import com.rinhadebackend.rinha2024q1java.repository.TransacaoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.hibernate.exception.LockAcquisitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.data.domain.Limit;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RinhaService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    @Autowired
    public RinhaService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @Retryable(
            retryFor = { CannotAcquireLockException.class, LockAcquisitionException.class },
            backoff = @Backoff(delay = 200, maxDelay = 8000) // UniformRandomBackOffPolicy
    )
    @Transactional
    public Optional<TransacaoResponse> realizarTransacao(Integer id, TransacaoRequest request) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) return Optional.empty();
        Cliente cliente = clienteOptional.get();

        char tipo = request.tipo().charAt(0);
        if(tipo == 'c') cliente.realizarCredito(request.valor().intValue());
        if(tipo == 'd') cliente.realizarDebito(request.valor().intValue());

        Transacao transacao = criarTransacao(request, cliente, tipo);
        cliente.addTransacao(transacao);
        clienteRepository.save(cliente);

        return Optional.of(new TransacaoResponse(cliente.getLimite(), cliente.getSaldo()));
    }

    @Transactional
    public Optional<ExtratoResponse> extrato(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) return Optional.empty();

        Cliente cliente = clienteOptional.get();
        List<ExtratoTransacaoResponse> transacoes = transacaoRepository
                .findByClienteIdOrderByRealizadaEmDesc(id, Limit.of(10)).stream()
                .map(t -> new ExtratoTransacaoResponse(
                        t.getValor(), t.getTipo(), t.getDescricao(), t.getRealizadaEm()))
                .toList();
        ExtratoSaldoResponse saldo = new ExtratoSaldoResponse(cliente.getSaldo(), LocalDateTime.now(), cliente.getLimite());

        return Optional.of(new ExtratoResponse(saldo, transacoes));
    }

    private Transacao criarTransacao(TransacaoRequest request, Cliente cliente, char tipo) {
        Transacao transacao = new Transacao();
        transacao.setCliente(cliente);
        transacao.setTipo(tipo);
        transacao.setValor(request.valor().intValue());
        transacao.setDescricao(request.descricao());
        transacao.setRealizadaEm(LocalDateTime.now());
        return transacao;
    }

}
