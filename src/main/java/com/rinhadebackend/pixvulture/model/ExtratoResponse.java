package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

public record ExtratoResponse(ExtratoSaldoResponse saldo, @JsonAlias("ultimas_transacoes") List<ExtratoTransacaoResponse> ultimasTransacoes) {
}
