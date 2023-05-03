package br.com.fiap.checkpoint2.controller.dto.pedido;

import br.com.fiap.checkpoint2.model.Pedido;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoRequestUpdate {
    @NotNull
    private Long numeroPedido;

    private String codigoCliente;

    private String dataPedido;

    public Pedido toResource() {
        Pedido pedido = new Pedido();
        pedido.setNumeroPedido(this.numeroPedido);
        pedido.setCodigoCliente(this.codigoCliente);
        pedido.setDataPedido(this.dataPedido);
        return pedido;
    }
}
