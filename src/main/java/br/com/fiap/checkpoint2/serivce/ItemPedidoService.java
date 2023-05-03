package br.com.fiap.checkpoint2.serivce;

import br.com.fiap.checkpoint2.controller.dto.itemPedido.ItemPedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.itemPedido.ItemPedidoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestUpdate;
import br.com.fiap.checkpoint2.model.ItemPedido;
import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAll() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido getById(Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public ItemPedido save(ItemPedidoRequestCreate itemPedidoRequestCreate) {
        return itemPedidoRepository.save(itemPedidoRequestCreate.toResource());
    }

    public ItemPedido update(ItemPedidoRequestUpdate itemPedido) {
        boolean exists = itemPedidoRepository.existsById(itemPedido.getSequencia());
        if (!exists) {
            throw new RuntimeException("Id não encontrado "
                    + itemPedido.getSequencia());
        }
        return itemPedidoRepository.save(itemPedido.toResource());
    }
}
