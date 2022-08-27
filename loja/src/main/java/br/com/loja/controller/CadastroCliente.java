package br.com.loja.controller;

import br.com.loja.dto.request.ClienteRequest;
import br.com.loja.dto.response.ClienteDto;
import br.com.loja.entity.Cliente;
import br.com.loja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clientes")
public class CadastroCliente {

    @Autowired
    ClienteRepository clienteRepository;


    @GetMapping
    public List<ClienteDto> listaClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDto.conveterparaDto(clientes);
    }

    /*
    @PostMapping
    public Cliente cadastroCliente(@RequestBody ClienteDto clienteDto){

        Cliente cliente = new Cliente();
        cliente.setCpf(clienteDto.getCpf());
        cliente.setNome(clienteDto.getNome());

        return clienteRepository.save(cliente);
    }

     */
    @PostMapping
    public ResponseEntity<ClienteDto> cadastra(@RequestBody ClienteRequest clienteRequest, UriComponentsBuilder uriBuilder){
        Cliente cliente = clienteRequest.converterCliente(clienteRepository);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getIdCliente()).toUri();

        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }
}
