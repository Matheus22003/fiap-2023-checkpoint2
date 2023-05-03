package br.com.fiap.checkpoint2.controller.dto.itemPedido;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.ItemPedido;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
public class ItemPedidoRequestUpdate {

    @NotNull
    private Long sequencia;

    private String numeroPedido;

    private String codigoProduto;

    private Integer quantidade;

    private Integer valorTotal;

    public ItemPedido toResource() {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setSequencia(getSequencia());
        itemPedido.setNumeroPedido(getNumeroPedido());
        itemPedido.setCodigoProduto(getCodigoProduto());
        itemPedido.setQuantidade(getQuantidade());
        itemPedido.setValorTotal(getValorTotal());
        return itemPedido;
    }
}
