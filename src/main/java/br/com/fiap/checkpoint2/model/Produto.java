package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long codigo_produto;

    @Column
    private String nome;

    @Column
    private Float preco;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(name = "data_garantia")
    private LocalDate dataGarantia;

    @Column(name = "em_estoque")
    private Boolean emEstoque;

}
