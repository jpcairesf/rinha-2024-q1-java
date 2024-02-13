package com.rinhadebackend.rinha2024q1java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ExtratoResponse(ExtratoSaldoResponse saldo, @JsonProperty("ultimas_transacoes") List<ExtratoTransacaoResponse> ultimasTransacoes) {
}
