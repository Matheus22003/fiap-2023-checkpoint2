package br.com.fiap.checkpoint2.controller.dto.produto;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.model.Produto;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProdutoRequestCreate {
    private String nome;

    private Float preco;

    private LocalDate dataValidade;

    private LocalDate dataGarantia;

    private Boolean emEstoque;

    public Produto toResource() {
        Produto produto = new Produto();
        produto.setNome(getNome());
        produto.setPreco(getPreco());
        produto.setDataValidade(getDataValidade());
        produto.setDataGarantia(getDataGarantia());
        produto.setEmEstoque(getEmEstoque());
        return produto;
    }
}
