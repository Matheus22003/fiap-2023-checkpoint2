package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.pedido.SearchedPedido;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.serivce.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(PedidoController.PEDIDOS)
public class PedidoController {
    public static final String PEDIDOS = "/pedidos";

    Logger log = getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;


    public PedidoController() {
    }

    @GetMapping
    public ResponseEntity<List<SearchedPedido>> listAll() {
        log.debug("GET | {}/ | Iniciado | listAll", PEDIDOS);
        List<SearchedPedido> pedidosList = pedidoService.getAll().stream().map(SearchedPedido::toDto).collect(toList());
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", PEDIDOS, pedidosList);
        return ok(pedidosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchedPedido> getById(@PathVariable Long id) {
        log.debug("GET | {}/{} | Iniciado | getById", PEDIDOS, id);
        SearchedPedido pedido = SearchedPedido.toDto(pedidoService.getById(id));
        log.debug("GET | {}/{} | FInalizado | getById | Entities: {}", PEDIDOS, id, pedido);
        return ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody PedidoRequestCreate pedido) {
        log.debug("GET | {}/ | Iniciado | listAll", PEDIDOS);
        Pedido pedido1 = pedidoService.save(pedido);
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", PEDIDOS, pedido1);
        return ok(pedido1);
    }

    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody PedidoRequestUpdate dto) {
        log.debug("GET | {}/ | Iniciado | update", PEDIDOS);
        Pedido pedido = pedidoService.update(dto);
        log.debug("GET | {}/ | FInalizado | update | Entities: {}", PEDIDOS, pedido);
        return ok(pedido);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("DELETE | {}/{} | Iniciado | deleteById", PEDIDOS, id);
        pedidoService.deleteById(id);
        log.info("DELETE | {}/{} | FInalizado | deleteById", PEDIDOS, id);
        return ok().build();
    }

}
