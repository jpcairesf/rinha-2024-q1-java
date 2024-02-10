package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

public record ExtratoOutput(SaldoDataOutput saldo, @JsonAlias("ultimas_transacoes") List<TransacaoOutput> ultimasTransacoes) {
}
