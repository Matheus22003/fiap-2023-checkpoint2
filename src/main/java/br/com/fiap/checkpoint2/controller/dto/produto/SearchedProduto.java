package br.com.fiap.checkpoint2.controller.dto.produto;

import br.com.fiap.checkpoint2.controller.dto.pedido.SearchedPedido;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.model.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Data
public class SearchedProduto {

    private Long codigoProduto;

    private String nome;

    private Float preco;

    private Boolean emEstoque;

    public static SearchedProduto toDto(Produto pessoa) {
        SearchedProduto dto = new SearchedProduto();
        dto.setCodigoProduto(pessoa.getCodigo_produto());
        dto.setNome(pessoa.getNome());
        dto.setPreco(pessoa.getPreco());
        dto.setEmEstoque(pessoa.getEmEstoque());
        return dto;
    }
}
