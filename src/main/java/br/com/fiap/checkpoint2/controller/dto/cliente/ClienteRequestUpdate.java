package br.com.fiap.checkpoint2.controller.dto.cliente;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
public class ClienteRequestUpdate {

    @NotNull
    private Long codigoCliente;

    private String nome;

    private String inscricaoFederal;

    private String cep;

    public Cliente toResource() {
        Cliente pedido = new Cliente();
        pedido.setCodigo_cliente(getCodigoCliente());
        pedido.setNome(getNome());
        pedido.setInscricaoFederal(getInscricaoFederal());
        pedido.setCep(getCep());
        return pedido;
    }
}
