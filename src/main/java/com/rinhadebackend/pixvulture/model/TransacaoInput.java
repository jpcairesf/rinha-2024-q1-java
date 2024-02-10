package com.rinhadebackend.pixvulture.model;

import com.rinhadebackend.pixvulture.domain.Tipo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record TransacaoInput(
        @NotNull @PositiveOrZero
        Integer valor,

        @NotNull
        Tipo tipo,

        @NotNull @Size(max = 10)
        String descricao
) { }
