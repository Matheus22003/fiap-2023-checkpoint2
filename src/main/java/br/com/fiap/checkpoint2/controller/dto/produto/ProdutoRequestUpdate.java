package br.com.fiap.checkpoint2.controller.dto.produto;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.model.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.AUTO;

@Data
public class ProdutoRequestUpdate {
    @NotNull
    private Long codigoProduto;

    private String nome;

    private Float preco;

    private LocalDate dataValidade;

    private LocalDate dataGarantia;

    private Boolean emEstoque;

    public Produto toResource() {
        Produto produto = new Produto();
        produto.setCodigo_produto(getCodigoProduto());
        produto.setNome(getNome());
        produto.setPreco(getPreco());
        produto.setDataValidade(getDataValidade());
        produto.setDataGarantia(getDataGarantia());
        produto.setEmEstoque(getEmEstoque());
        return produto;
    }
}
