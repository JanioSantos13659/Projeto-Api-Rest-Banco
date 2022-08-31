package br.com.banco;

import br.com.banco.repository.ClienteRepository;
import br.com.banco.service.ClienteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={br.com.banco.BancoApplication.class})
public class ClienteServiceTeste {


    @Autowired
    private ClienteService clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @Test
    public void deveriaCadastrarCliente(){

    }
}
