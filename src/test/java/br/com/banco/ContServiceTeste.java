package br.com.banco;

import br.com.banco.dto.request.DepositoRequest;
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
    ContaService contaService;

    @Autowired
    ContaRepository contaRepository;


    @Test
    public void DeveriafazerDepositoEmConta(){

      DepositoRequest depositoConta = new DepositoRequest(192.,"12345");
      contaService.depositoContas(depositoConta);

        Conta conta = contaRepository.findByNumeroConta(depositoConta.getNumeroContaDeposito());

        Double saldoAtual = conta.getSaldo();

        Assert.assertEquals(saldoAtual, depositoConta.getValorDeposito());

    }

}
