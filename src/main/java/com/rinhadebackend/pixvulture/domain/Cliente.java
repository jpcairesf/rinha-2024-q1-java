package com.rinhadebackend.pixvulture.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

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

    @OneToMany(mappedBy = "cliente")
    private List<Transacao> transacoes;

}
