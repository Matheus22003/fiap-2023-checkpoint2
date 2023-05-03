package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "itens_pedidos")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long sequencia;

    @Column(name = "numero_pedido")
    private String numeroPedido;

    @Column(name = "codigo_produto")
    private String codigoProduto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor_total")
    private Integer valorTotal;
}
