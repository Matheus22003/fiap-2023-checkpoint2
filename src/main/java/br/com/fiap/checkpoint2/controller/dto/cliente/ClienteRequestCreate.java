package br.com.fiap.checkpoint2.controller.dto.cliente;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
public class ClienteRequestCreate {
    @Column
    private String nome;

    @Column(name = "inscricao_federal")
    private String inscricaoFederal;

    @Column(name = "cep")
    private String cep;

    public Cliente toResource() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.getNome());
        cliente.setInscricaoFederal(this.getInscricaoFederal());
        cliente.setCep(this.getCep());
        return cliente;
    }
}
