package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ExtratoResponse(ExtratoSaldoResponse saldo, @JsonProperty("ultimas_transacoes") List<ExtratoTransacaoResponse> ultimasTransacoes) {
}
