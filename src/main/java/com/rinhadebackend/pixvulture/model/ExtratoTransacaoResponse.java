package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public record ExtratoTransacaoResponse(Integer valor, char tipo, String descricao, @JsonProperty("realizada_em") LocalDateTime realizadaEm) { }
