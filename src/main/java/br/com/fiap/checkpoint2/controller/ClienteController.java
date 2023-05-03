package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.controller.dto.cliente.ClienteRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.cliente.ClienteRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.cliente.SearchedCliente;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestUpdate;
import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.serivce.ClienteService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(ClienteController.CLIENTES)
public class ClienteController {
    public static final String CLIENTES = "/clientes";

    Logger log = getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;


    public ClienteController() {
    }

    @GetMapping
    public ResponseEntity<List<SearchedCliente>> listAll() {
        log.debug("GET | {}/ | Iniciado | listAll", CLIENTES);
        List<SearchedCliente> pedidosList = clienteService.getAll().stream().map(SearchedCliente::toDto).collect(toList());
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", CLIENTES, pedidosList);
        return ok(pedidosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchedCliente> getById(@PathVariable Long id) {
        log.debug("GET | {}/{} | Iniciado | getById", CLIENTES, id);
        SearchedCliente cliente = SearchedCliente.toDto(clienteService.getById(id));
        log.debug("GET | {}/{} | FInalizado | getById | Entities: {}", CLIENTES, id, cliente);
        return ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody ClienteRequestCreate dto) {
        log.debug("GET | {}/ | Iniciado | listAll", CLIENTES);
        Cliente cliente = clienteService.save(dto);
        log.debug("GET | {}/ | FInalizado | listAll | Entities: {}", CLIENTES, cliente);
        return ok(cliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody ClienteRequestUpdate dto) {
        log.debug("GET | {}/ | Iniciado | update", CLIENTES);
        Cliente cliente = clienteService.update(dto);
        log.debug("GET | {}/ | FInalizado | update | Entities: {}", CLIENTES, cliente);
        return ok(cliente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("DELETE | {}/{} | Iniciado | deleteById", CLIENTES, id);
        clienteService.deleteById(id);
        log.info("DELETE | {}/{} | FInalizado | deleteById", CLIENTES, id);
        return ok().build();
    }

}
