package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDateTime;

public record SaldoDataOutput(Integer total, @JsonAlias("data_extrato") LocalDateTime dataExtrato, Integer limite) {
}
