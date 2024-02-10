package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDateTime;

public record ExtratoTransacaoResponse(Integer valor, char tipo, String descricao, @JsonAlias("realizada_em") LocalDateTime realizadaEm) { }
