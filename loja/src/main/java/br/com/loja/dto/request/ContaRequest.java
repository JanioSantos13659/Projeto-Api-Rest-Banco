package br.com.loja.dto.request;

import br.com.loja.dto.response.ContaDto;
import br.com.loja.entity.Cliente;
import br.com.loja.entity.Conta;
import br.com.loja.repository.ClienteRepository;
import br.com.loja.repository.ContaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Optional;


@Getter
@Setter
public class ContaRequest {

    private Integer idCliente;
    private BigDecimal saldo;
    private Long numeroConta;

    /*
    public Conta converterConta(ContaRepository contaRepository) {
        Cliente cliente = contaRepository.findByidConta(idCliente);
        return new Conta(idCliente,saldo,numeroConta, Optional.ofNullable(cliente));
   }

     */



}


