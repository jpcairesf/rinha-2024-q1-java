package com.rinhadebackend.pixvulture.domain;

public enum Tipo {
    C('c'), D('c');

    char descricao;

    Tipo(char descricao) {
        this. descricao = descricao;
    }
}
