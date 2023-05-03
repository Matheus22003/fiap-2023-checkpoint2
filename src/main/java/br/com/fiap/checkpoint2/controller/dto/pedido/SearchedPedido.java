package br.com.fiap.checkpoint2.controller.dto.pedido;

import br.com.fiap.checkpoint2.model.Pedido;
import lombok.Data;

@Data
public class SearchedPedido {

    private Long numeroPedido;

    private String codigoCliente;

    public static SearchedPedido toDto(Pedido pessoa) {
        SearchedPedido dto = new SearchedPedido();
        dto.setNumeroPedido(pessoa.getNumeroPedido());
        dto.setCodigoCliente(pessoa.getCodigoCliente());
        return dto;
    }
}
