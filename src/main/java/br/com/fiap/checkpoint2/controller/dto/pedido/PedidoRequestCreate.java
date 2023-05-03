package br.com.fiap.checkpoint2.controller.dto.pedido;

import br.com.fiap.checkpoint2.model.Pedido;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoRequestCreate {
    private String codigoCliente;

    private String dataPedido;

    public Pedido toResource() {
        Pedido pedido = new Pedido();
        pedido.setCodigoCliente(this.codigoCliente);
        pedido.setDataPedido(this.dataPedido);
        return pedido;
    }
}
