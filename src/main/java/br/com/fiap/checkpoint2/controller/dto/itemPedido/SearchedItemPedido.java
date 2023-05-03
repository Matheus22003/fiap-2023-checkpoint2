package br.com.fiap.checkpoint2.controller.dto.itemPedido;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.ItemPedido;
import lombok.Data;

@Data
public class SearchedItemPedido {

    private Long sequencia;

    private String numeroPedido;

    private String codigoProduto;

    private Integer quantidade;

    private Integer valorTotal;

    public static SearchedItemPedido toDto(ItemPedido itemPedido) {
        SearchedItemPedido dto = new SearchedItemPedido();
        dto.setSequencia(itemPedido.getSequencia());
        dto.setNumeroPedido(itemPedido.getNumeroPedido());
        dto.setCodigoProduto(itemPedido.getCodigoProduto());
        dto.setQuantidade(itemPedido.getQuantidade());
        dto.setValorTotal(itemPedido.getValorTotal());
        return dto;
    }
}
