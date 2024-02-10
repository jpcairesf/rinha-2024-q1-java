package com.rinhadebackend.pixvulture.repository;

import com.rinhadebackend.pixvulture.domain.Transacao;
import java.util.List;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<Transacao> findByClienteIdOrderByRealizadaEmDesc(Integer clienteId, Limit limit);

}
