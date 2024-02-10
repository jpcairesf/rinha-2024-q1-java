package com.rinhadebackend.pixvulture.repository;

import com.rinhadebackend.pixvulture.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

//    @Modifying
//    @Query
//    TransacaoResponse realizarCredito(Integer id, Integer valor, String descricao);
//
//    @Modifying
//    @Query("""
//            UPDATE CLIENTE c
//            IF
//            SET c.VALOR = c.VALOR - :valor
//            WHERE c.id = :id
//            RETURNING
//            """)
//    TransacaoResponse realizarDebito(Integer id, Integer valor, String descricao);

}
