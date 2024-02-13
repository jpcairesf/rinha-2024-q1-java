package com.rinhadebackend.rinha2024q1java.repository;

import com.rinhadebackend.rinha2024q1java.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
