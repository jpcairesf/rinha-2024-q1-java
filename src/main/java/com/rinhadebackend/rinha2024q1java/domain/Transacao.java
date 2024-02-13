package com.rinhadebackend.rinha2024q1java.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "TRANSACAO_SEQ", sequenceName = "TRANSACAO_SEQ")
@Table(name = "TRANSACAO", indexes =
    @Index(name = "REALIZADA_EM_INDEX", columnList = "REALIZADA_EM DESC"))
public class Transacao {

    @Id
    @GeneratedValue(generator = "TRANSACAO_SEQ")
    @Column(name = "TRANSACAO_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @Column(name = "TIPO", nullable = false)
    private char tipo;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "REALIZADA_EM", nullable = false)
    private LocalDateTime realizadaEm;

    public Transacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getRealizadaEm() {
        return realizadaEm;
    }

    public void setRealizadaEm(LocalDateTime realizadaEm) {
        this.realizadaEm = realizadaEm;
    }
}
