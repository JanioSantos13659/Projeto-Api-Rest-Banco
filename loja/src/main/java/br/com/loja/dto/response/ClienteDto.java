package br.com.loja.dto.response;

import br.com.loja.entity.Cliente;
import br.com.loja.entity.Conta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClienteDto {

    private String nome;
    private String cpf;

    public ClienteDto(Cliente cliente) {
         this.nome = getNome();
         this.cpf = getCpf();
    }

    public static List<ClienteDto> conveterparaDto(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }
}
