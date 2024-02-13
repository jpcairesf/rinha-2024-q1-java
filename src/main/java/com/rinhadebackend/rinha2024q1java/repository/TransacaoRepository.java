package com.rinhadebackend.rinha2024q1java.repository;

import com.rinhadebackend.rinha2024q1java.domain.Transacao;
import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

//    @Lock(LockModeType.PESSIMISTIC_READ)
    List<Transacao> findByClienteIdOrderByRealizadaEmDesc(Integer clienteId, Limit limit);

}
