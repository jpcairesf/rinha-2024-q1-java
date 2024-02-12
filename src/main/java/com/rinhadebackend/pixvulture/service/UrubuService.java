package com.rinhadebackend.pixvulture.service;

import com.rinhadebackend.pixvulture.domain.Cliente;
import com.rinhadebackend.pixvulture.domain.Transacao;
import com.rinhadebackend.pixvulture.model.ExtratoResponse;
import com.rinhadebackend.pixvulture.model.ExtratoSaldoResponse;
import com.rinhadebackend.pixvulture.model.ExtratoTransacaoResponse;
import com.rinhadebackend.pixvulture.model.TransacaoRequest;
import com.rinhadebackend.pixvulture.model.TransacaoResponse;
import com.rinhadebackend.pixvulture.repository.ClienteRepository;
import com.rinhadebackend.pixvulture.repository.TransacaoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UrubuService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    @Transactional
    public Optional<TransacaoResponse> realizarTransacao(Integer id, TransacaoRequest request) {
        char tipo = request.tipo().charAt(0);
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isEmpty()) return Optional.empty();

        Cliente cliente = clienteOptional.get();
        if(tipo == 'c') cliente.realizarCredito(request.valor());
        if(tipo == 'd') cliente.realizarDebito(request.valor());

        Transacao transacao = new Transacao();
        transacao.setCliente(cliente);
        transacao.setTipo(tipo);
        transacao.setValor(request.valor());
        transacao.setDescricao(request.descricao());
        transacao.setRealizadaEm(LocalDateTime.now());

        clienteRepository.save(cliente);
        transacaoRepository.save(transacao);
        return Optional.of(new TransacaoResponse(cliente.getLimite(), cliente.getSaldo()));
    }

    @Transactional(readOnly = true)
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

}
