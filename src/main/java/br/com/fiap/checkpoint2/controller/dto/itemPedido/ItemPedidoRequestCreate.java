package br.com.fiap.checkpoint2.controller.dto.itemPedido;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.ItemPedido;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ItemPedidoRequestCreate {
    private String numeroPedido;

    private String codigoProduto;

    private Integer quantidade;

    private Integer valorTotal;

    public ItemPedido toResource() {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNumeroPedido(this.getNumeroPedido());
        itemPedido.setCodigoProduto(this.getCodigoProduto());
        itemPedido.setQuantidade(this.getQuantidade());
        itemPedido.setValorTotal(this.getValorTotal());
        return itemPedido;
    }
}
