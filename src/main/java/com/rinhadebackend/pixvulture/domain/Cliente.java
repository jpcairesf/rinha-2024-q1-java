package com.rinhadebackend.pixvulture.domain;

import com.rinhadebackend.pixvulture.DomainException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ")
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(generator = "TRANSACAO_SEQ")
    @Column(name = "CLIENTE_ID", nullable = false)
    private Integer id;

    @Column(name = "SALDO", nullable = false)
    private Integer saldo;

    @Column(name = "LIMITE", nullable = false)
    private Integer limite;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Transacao> transacoes;

    public void realizarCredito(Integer valor) {
        this.saldo += valor;
    }

    public void realizarDebito(Integer valor) {
        if (saldo - valor < -limite) throw new DomainException("Limite insuficiente para realização do débito.");
        this.saldo += valor;
    }

    public void adicionarTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
    }

}
