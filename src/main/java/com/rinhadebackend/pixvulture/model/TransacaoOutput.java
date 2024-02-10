package com.rinhadebackend.pixvulture.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDateTime;

public record TransacaoOutput(Integer valor, String tipo, String descricao, @JsonAlias("realizada_em") LocalDateTime realizadaEm) { }
