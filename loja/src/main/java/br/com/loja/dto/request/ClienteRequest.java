package br.com.loja.dto.request;

import br.com.loja.entity.Cliente;
import br.com.loja.entity.Conta;
import br.com.loja.repository.ClienteRepository;
import br.com.loja.repository.ContaRepository;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ClienteRequest {

    private String nome;
    private String cpf;

    public Cliente converterCliente(ClienteRepository clienteRepository) {
      Cliente cliente = clienteRepository.findBynome(nome);
      return new Cliente(cpf,nome,cliente);

    }
}
