package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name = "numero_pedido")
    @GeneratedValue(strategy = AUTO)
    private Long numeroPedido;

    @Column(name = "codigo_cliente")
    private String codigoCliente;

    @Column(name = "data_pedido")
    private String dataPedido;


}
