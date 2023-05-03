package br.com.fiap.checkpoint2.serivce;

import br.com.fiap.checkpoint2.controller.dto.cliente.ClienteRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.cliente.ClienteRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestUpdate;
import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente save(ClienteRequestCreate pedido) {
        return clienteRepository.save(pedido.toResource());
    }

    public Cliente update(ClienteRequestUpdate pedido) {
        boolean exists = clienteRepository.existsById(pedido.getCodigoCliente());
        if (!exists) {
            throw new RuntimeException("Id não encontrado "
                    + pedido.getCodigoCliente());
        }
        return clienteRepository.save(pedido.toResource());
    }
}
