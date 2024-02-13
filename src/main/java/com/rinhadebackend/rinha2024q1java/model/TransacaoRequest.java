package com.rinhadebackend.rinha2024q1java.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record TransacaoRequest(
        @NotNull @PositiveOrZero
        Integer valor,

        @NotEmpty @Pattern(regexp = "[cd]")
        String tipo,

        @NotNull @Size(max = 10)
        String descricao
) { }
