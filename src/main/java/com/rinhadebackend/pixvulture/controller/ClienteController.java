package com.rinhadebackend.pixvulture.controller;

import com.rinhadebackend.pixvulture.model.ExtratoResponse;
import com.rinhadebackend.pixvulture.model.TransacaoResponse;
import com.rinhadebackend.pixvulture.model.TransacaoRequest;
import com.rinhadebackend.pixvulture.service.UrubuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final UrubuService service;

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<TransacaoResponse> transacoes(@PathVariable Integer id, @RequestBody TransacaoRequest request) {
        return service.realizarTransacao(id, request)
                .map(response -> status(OK).body(response))
                .orElseGet(() -> status(NOT_FOUND).build());
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtratoResponse> extrato(@PathVariable Integer id) {
        return null;
    }

}
