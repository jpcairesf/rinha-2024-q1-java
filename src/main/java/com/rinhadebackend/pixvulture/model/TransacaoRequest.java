package com.rinhadebackend.pixvulture.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record TransacaoRequest(
        @NotNull @PositiveOrZero
        Integer valor,

        @NotNull
        char tipo,

        @NotNull @Size(max = 10)
        String descricao
) { }
