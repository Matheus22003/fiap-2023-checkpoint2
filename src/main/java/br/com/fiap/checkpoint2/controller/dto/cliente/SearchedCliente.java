package br.com.fiap.checkpoint2.controller.dto.cliente;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.model.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Data
public class SearchedCliente {

    private Long codigo_cliente;

    private String nome;

    private String inscricaoFederal;

    private String cep;

    public static SearchedCliente toDto(Cliente pessoa) {
        SearchedCliente dto = new SearchedCliente();
        dto.setCodigo_cliente(pessoa.getCodigo_cliente());
        dto.setNome(pessoa.getNome());
        dto.setInscricaoFederal(pessoa.getInscricaoFederal());
        dto.setCep(pessoa.getCep());
        return dto;
    }
}
