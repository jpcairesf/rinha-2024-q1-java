package com.rinhadebackend.pixvulture.repository;

import com.rinhadebackend.pixvulture.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
