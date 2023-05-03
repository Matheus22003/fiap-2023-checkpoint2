package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.pedido.SearchedPedido;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.produto.SearchedProduto;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.serivce.ProdutoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(ProdutoController.PRODUTOS)
public class ProdutoController {
    public static final String PRODUTOS = "/produtos";

    Logger log = getLogger(ProdutoController.class);

    @Autowired
    private ProdutoService produtoService;


    public ProdutoController() {
    }

    @GetMapping
    public ResponseEntity<List<SearchedProduto>> listAll() {
        log.debug("GET | {}/ | Iniciado | listAll", PRODUTOS);
        List<SearchedProduto> pedidosList = produtoService.getAll().stream().map(SearchedProduto::toDto).collect(toList());
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", PRODUTOS, pedidosList);
        return ok(pedidosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchedProduto> getById(@PathVariable Long id) {
        log.debug("GET | {}/{} | Iniciado | getById", PRODUTOS, id);
        SearchedProduto produto = SearchedProduto.toDto(produtoService.getById(id));
        log.debug("GET | {}/{} | FInalizado | getById | Entities: {}", PRODUTOS, id, produto);
        return ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody ProdutoRequestCreate dto) {
        log.debug("GET | {}/ | Iniciado | listAll", PRODUTOS);
        Produto produto = produtoService.save(dto);
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", PRODUTOS, produto);
        return ok(produto);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody ProdutoRequestUpdate dto) {
        log.debug("GET | {}/ | Iniciado | update", PRODUTOS);
        Produto produto = produtoService.update(dto);
        log.debug("GET | {}/ | FInalizado | update | Entities: {}", PRODUTOS, produto);
        return ok(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("DELETE | {}/{} | Iniciado | deleteById", PRODUTOS, id);
        produtoService.deleteById(id);
        log.info("DELETE | {}/{} | FInalizado | deleteById", PRODUTOS, id);
        return ok().build();
    }

}
