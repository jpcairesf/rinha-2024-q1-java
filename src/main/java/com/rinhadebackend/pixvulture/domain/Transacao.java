package com.rinhadebackend.pixvulture.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "TRANSACAO_SEQ", sequenceName = "TRANSACAO_SEQ")
@Table(name = "TRANSACAO")
public class Transacao {

    @Id
    @GeneratedValue(generator = "TRANSACAO_SEQ")
    @Column(name = "TRANSACAO_ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @Column(name = "TIPO", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "REALIZADA_EM", nullable = false)
    private LocalDateTime realizadaEm;
}
