package br.com.loja.controller;


import br.com.loja.dto.request.ContaRequest;
import br.com.loja.dto.response.ClienteDto;
import br.com.loja.dto.response.ContaDto;
import br.com.loja.entity.Cliente;
import br.com.loja.entity.Conta;
import br.com.loja.repository.ClienteRepository;
import br.com.loja.repository.ContaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/contas")
public class CadastroConta {


    @Autowired
    ContaRepository contaRepository;


    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<ContaDto> listaContas(){
        List<Conta> contas= contaRepository.findAll();
        return ContaDto.conveterDto(contas);
    }
    /*


    @PostMapping
    public Conta cadastroConta(@RequestBody ContaDto contaDto) {

        Optional<Cliente> cliente = clienteRepository.findById(contaDto.getIdCliente());

        Conta conta = new Conta();
        conta.setNumeroConta(contaDto.getNumeroConta());
        conta.setSaldo(contaDto.getSaldo());
        conta.setCliente(cliente.get());

        return contaRepository.save(conta);
    }



    @PostMapping
    public ResponseEntity<ContaDto> cadastra(@RequestBody ContaRequest contaRequest, UriComponentsBuilder uriBuilder){
        Conta conta = contaRequest.converterConta(contaRepository);
        contaRepository.save(conta);

        URI uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getIdConta()).toUri();

        return ResponseEntity.created(uri).body(new ContaDto(conta));
    }

     */


}


