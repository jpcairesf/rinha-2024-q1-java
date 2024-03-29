package com.rinhadebackend.rinha2024q1java.controller;

import com.rinhadebackend.rinha2024q1java.model.ExtratoResponse;
import com.rinhadebackend.rinha2024q1java.model.TransacaoRequest;
import com.rinhadebackend.rinha2024q1java.model.TransacaoResponse;
import com.rinhadebackend.rinha2024q1java.service.RinhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final RinhaService service;

    @Autowired
    public ClienteController(RinhaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<String> health() {
        return status(OK).body("It's healthy!");
    }

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<TransacaoResponse> transacoes(
            @PathVariable Integer id, @RequestBody @Valid TransacaoRequest request) {
        return service.realizarTransacao(id, request)
                .map(response -> status(OK).body(response))
                .orElseGet(() -> status(NOT_FOUND).build());
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtratoResponse> extrato(@PathVariable Integer id) {
        return service.extrato(id)
                .map(response -> status(OK).body(response))
                .orElseGet(() -> status(NOT_FOUND).build());
    }

}
