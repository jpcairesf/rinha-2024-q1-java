package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public record ExtratoSaldoResponse(Integer total, @JsonProperty("data_extrato") LocalDateTime dataExtrato, Integer limite) {
}
