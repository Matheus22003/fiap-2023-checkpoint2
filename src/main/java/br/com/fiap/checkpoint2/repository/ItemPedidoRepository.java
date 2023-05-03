package br.com.fiap.checkpoint2.repository;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
