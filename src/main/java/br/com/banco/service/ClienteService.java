package br.com.banco.service;

import br.com.banco.converter.ClienteConverter;
import br.com.banco.dto.request.ClienteRequest;
import br.com.banco.dto.response.ClienteResponse;
import br.com.banco.entity.Cliente;
import br.com.banco.exception.NotFoundExeception;
import br.com.banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteConverter clienteConverter;


    public List<ClienteResponse> getAllClientes() {

        List<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll();

        return clienteConverter.convertToResponse(clientes);
    }
    public ClienteResponse getCliente(Integer idCliente) {

        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new NotFoundExeception(idCliente));

        return clienteConverter.convertToResponse(cliente);
    }

    public ClienteResponse addCliente(ClienteRequest clienteRequest) {

        Cliente cliente = clienteConverter.convertToEntity(clienteRequest);

        return clienteConverter.convertToResponse(clienteRepository.save(cliente));

    }

}
