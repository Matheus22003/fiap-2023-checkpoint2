package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.controller.dto.itemPedido.ItemPedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.itemPedido.ItemPedidoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.itemPedido.SearchedItemPedido;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.produto.SearchedProduto;
import br.com.fiap.checkpoint2.model.ItemPedido;
import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.serivce.ItemPedidoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(ItemPedidoController.ITEM_PEDIDOS)
public class ItemPedidoController {
    public static final String ITEM_PEDIDOS = "/item-pedidos";

    Logger log = getLogger(ItemPedidoController.class);

    @Autowired
    private ItemPedidoService itemPedidoService;


    public ItemPedidoController() {
    }

    @GetMapping
    public ResponseEntity<List<SearchedItemPedido>> listAll() {
        log.debug("GET | {}/ | Iniciado | listAll", ITEM_PEDIDOS);
        List<SearchedItemPedido> pedidosList = itemPedidoService.getAll().stream().map(SearchedItemPedido::toDto).collect(toList());
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", ITEM_PEDIDOS, pedidosList);
        return ok(pedidosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchedItemPedido> getById(@PathVariable Long id) {
        log.debug("GET | {}/{} | Iniciado | getById", ITEM_PEDIDOS, id);
        SearchedItemPedido produto = SearchedItemPedido.toDto(itemPedidoService.getById(id));
        log.debug("GET | {}/{} | FInalizado | getById | Entities: {}", ITEM_PEDIDOS, id, produto);
        return ok(produto);
    }

    @PostMapping
    public ResponseEntity<ItemPedido> create(@RequestBody ItemPedidoRequestCreate dto) {
        log.debug("GET | {}/ | Iniciado | listAll", ITEM_PEDIDOS);
        ItemPedido produto = itemPedidoService.save(dto);
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", ITEM_PEDIDOS, produto);
        return ok(produto);
    }

    @PutMapping
    public ResponseEntity<ItemPedido> update(@RequestBody ItemPedidoRequestUpdate dto) {
        log.debug("GET | {}/ | Iniciado | update", ITEM_PEDIDOS);
        ItemPedido produto = itemPedidoService.update(dto);
        log.debug("GET | {}/ | FInalizado | update | Entities: {}", ITEM_PEDIDOS, produto);
        return ok(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("DELETE | {}/{} | Iniciado | deleteById", ITEM_PEDIDOS, id);
        itemPedidoService.deleteById(id);
        log.info("DELETE | {}/{} | FInalizado | deleteById", ITEM_PEDIDOS, id);
        return ok().build();
    }

}
