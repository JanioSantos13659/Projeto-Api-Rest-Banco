package br.com.banco;

import br.com.banco.entity.Conta;
import br.com.banco.repository.ContaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={br.com.banco.BancoApplication.class})
public class ContaRepositoryTeste {

    @Autowired
   private ContaRepository contaRepository;

    @Test
    public void deveriaPegarNumeroDaContaNoBancoDeDados(){
        String numeroConta = "12345";
        Conta conta = contaRepository.findByNumeroConta(numeroConta);
        Assert.assertNotNull(conta);
        Assert.assertEquals(numeroConta, conta.getNumeroConta());
    }

    @Test
    public void deveriaRetornaNuloSeNaoEstiverCadastrado(){
        String numeroConta = "12385";
        Conta conta = contaRepository.findByNumeroConta(numeroConta);
        Assert.assertNull(conta);

    }
}

