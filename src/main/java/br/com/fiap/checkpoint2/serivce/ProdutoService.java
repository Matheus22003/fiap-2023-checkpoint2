package br.com.fiap.checkpoint2.serivce;

import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestUpdate;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto save(ProdutoRequestCreate produtoRequestCreate) {
        return produtoRepository.save(produtoRequestCreate.toResource());
    }

    public Produto update(ProdutoRequestUpdate produto) {
        boolean exists = produtoRepository.existsById(produto.getCodigoProduto());
        if (!exists) {
            throw new RuntimeException("Id não encontrado "
                    + produto.getCodigoProduto());
        }
        return produtoRepository.save(produto.toResource());
    }
}
