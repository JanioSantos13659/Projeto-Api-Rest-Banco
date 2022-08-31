package br.com.banco.controller;

import br.com.banco.dto.request.ContaRequest;
import br.com.banco.dto.request.DepositoRequest;
import br.com.banco.dto.request.TransferenciaRequest;
import br.com.banco.dto.response.ContaResponse;
import br.com.banco.dto.response.DepositoResponse;
import br.com.banco.dto.response.TransferenciaResponse;
import br.com.banco.repository.ContaRepository;
import br.com.banco.service.ContaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "api/contas")
public class ContaController {

    Logger logger = LoggerFactory.getLogger(ContaController.class);

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    ContaService contaService;

    @GetMapping
    public List<ContaResponse> getAllContas() {
        return this.contaService.getAllContas();
    }

    @GetMapping({"idConta"})
    public ContaResponse getCliente(@PathVariable Integer idConta) {

        logger.trace("Request - {}", idConta);
        return contaService.getConta(idConta);
    }

    @PostMapping
    public ContaResponse addConta(@Valid @RequestBody ContaRequest contaRequest) {
        return contaService.addConta(contaRequest);

    }

    @PutMapping(value = "tranferencia")
    public TransferenciaResponse transferenciaConta(@Valid @RequestBody TransferenciaRequest transferenciaRequest) {
        return contaService.transfereEntreContas(transferenciaRequest);

    }
    @PutMapping(value = "deposito")
    public DepositoResponse depositoConta(@Valid @RequestBody DepositoRequest depositoRequest) {
        return contaService.depositoContas(depositoRequest);

    }


}


