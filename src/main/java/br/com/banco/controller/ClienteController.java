package br.com.banco.controller;


import br.com.banco.dto.request.ClienteRequest;
import br.com.banco.dto.response.ClienteResponse;
import br.com.banco.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

     Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public List<ClienteResponse> getAllClientes() {
        return this.clienteService.getAllClientes();
    }

    @GetMapping(value = "{idCliente}")
    public ClienteResponse getCliente(@PathVariable Integer idCliente) {

        logger.trace("Request - {}", idCliente);
        return clienteService.getCliente(idCliente);
    }

    @PostMapping
    public ClienteResponse addCliente(@Valid @RequestBody ClienteRequest clienteRequest) {

        return clienteService.addCliente(clienteRequest);
    }

}
