package br.com.banco;

import br.com.banco.dto.request.ContaRequest;
import br.com.banco.dto.request.DepositoRequest;
import br.com.banco.dto.request.TransferenciaRequest;
import br.com.banco.dto.response.ContaResponse;
import br.com.banco.dto.response.DepositoResponse;
import br.com.banco.dto.response.TransferenciaResponse;
import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;
import br.com.banco.service.ContaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={br.com.banco.BancoApplication.class})
public class ContServiceTeste {

    @Autowired
    private ContaService contaService;

    @Autowired
    private DepositoRequest depositoRequest;

    @Autowired
    private DepositoResponse depositoResponse;

    @Autowired
    ContaRepository contaRepository;

    @Test
    public void depositoDeveriaSerValorForInvalido(){

        Conta contaPaulo = new Conta();
        contaPaulo.setNumeroConta("10205");
        contaPaulo.setSaldo(200);

        Conta contaMarcela = new Conta();
        contaMarcela.setNumeroConta("12345");
        contaMarcela.setSaldo(100);
        
    }


}
