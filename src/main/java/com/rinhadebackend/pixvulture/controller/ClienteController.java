package com.rinhadebackend.pixvulture.controller;

import com.rinhadebackend.pixvulture.model.ExtratoOutput;
import com.rinhadebackend.pixvulture.model.SaldoOutput;
import com.rinhadebackend.pixvulture.model.TransacaoInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/clientes")
public class ClienteController {

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<SaldoOutput> transacoes(@PathVariable Integer id, @RequestBody TransacaoInput input) {
        return null;
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtratoOutput> extrato(@PathVariable Integer id) {
        return null;
    }

}
