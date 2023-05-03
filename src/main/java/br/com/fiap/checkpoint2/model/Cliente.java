package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long codigo_cliente;

    @Column
    private String nome;

    @Column(name = "inscricao_federal")
    private String inscricaoFederal;

    @Column(name = "cep")
    private String cep;
}
