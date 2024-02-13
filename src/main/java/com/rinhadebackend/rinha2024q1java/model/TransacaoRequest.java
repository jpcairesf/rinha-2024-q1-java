package com.rinhadebackend.rinha2024q1java.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.Range;

public record TransacaoRequest(
        @NotNull @PositiveOrZero @Digits(integer = 1000000000, fraction = 0)
        BigDecimal valor,

        @NotEmpty @Pattern(regexp = "[cd]")
        String tipo,

        @NotBlank @Size(max = 10)
        String descricao
) { }
