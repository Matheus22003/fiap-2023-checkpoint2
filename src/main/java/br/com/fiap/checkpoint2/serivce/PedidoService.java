package br.com.fiap.checkpoint2.serivce;

import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestUpdate;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public Pedido getById(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido save(PedidoRequestCreate pedido) {
        return pedidoRepository.save(pedido.toResource());
    }

    public Pedido update(PedidoRequestUpdate pedido) {
        boolean exists = pedidoRepository.existsById(pedido.getNumeroPedido());
        if (!exists) {
            throw new RuntimeException("Id não encontrado "
                    + pedido.getNumeroPedido());
        }
        return pedidoRepository.save(pedido.toResource());
    }
}
