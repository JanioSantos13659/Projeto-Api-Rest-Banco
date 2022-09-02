package br.com.banco.converter;

import br.com.banco.dto.request.ClienteRequest;
import br.com.banco.dto.response.ClienteResponse;
import br.com.banco.entity.Cliente;
import br.com.banco.repository.ClienteRepository;
import br.com.banco.service.ClienteService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class ClienteConverter {

    @Autowired
    ClienteService clienteService;

    @Autowired
    Converter converter;

    @Autowired
    ContaConverter contaConverter;

    @Autowired
    ClienteConverter clienteConverter;

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente convertToEntity(ClienteRequest clienteRequest) {

            Cliente cliente = new Cliente();
            cliente.setNome(clienteRequest.getNome());
            cliente.setCpf(clienteRequest.getCpf());

            return cliente;
    }

    public ClienteResponse convertToResponse(Cliente cliente) {

        ClienteResponse clienteResponse = new ClienteResponse();

        clienteResponse.setIdCliente(cliente.getIdCliente());
        clienteResponse.setCpf(cliente.getCpf());
        clienteResponse.setNome(cliente.getNome());

        return clienteResponse;
    }

    public ClienteResponse convertToCliente(Cliente cliente) {

        return Converter.map(cliente, ClienteResponse.class);
    }


    public List<ClienteResponse> convertToResponse(List<Cliente> vagas) {

        List<ClienteResponse> list = vagas.stream()
                .map(entity -> convertToResponse(entity))
                .collect(Collectors.toList());

        return list;
    }

}
