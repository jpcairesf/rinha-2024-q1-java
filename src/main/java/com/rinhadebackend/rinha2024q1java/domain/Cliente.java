package com.rinhadebackend.rinha2024q1java.domain;

import com.rinhadebackend.rinha2024q1java.exception.DomainException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(generator = "TRANSACAO_SEQ")
    @Column(name = "CLIENTE_ID", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("REALIZADA_EM DESC")
    private List<Transacao> transacoes = new ArrayList<>();

    @Column(name = "SALDO", nullable = false)
    private Integer saldo;

    @Column(name = "LIMITE", nullable = false)
    private Integer limite;

    public void realizarCredito(Integer valor) {
        this.saldo += valor;
    }

    public void realizarDebito(Integer valor) {
        if (saldo - valor < -limite) throw new DomainException("Limite insuficiente para realização do débito.");
        this.saldo += valor;
    }

    public void addTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }
}
