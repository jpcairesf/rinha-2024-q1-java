package com.rinhadebackend.rinha2024q1java.repository;

import com.rinhadebackend.rinha2024q1java.domain.Transacao;
import java.util.List;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findByClienteIdOrderByRealizadaEmDesc(Integer clienteId, Limit limit);

}
