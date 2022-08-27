package br.com.loja.service;
import br.com.loja.entity.Conta;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DepositoService {

    public void ValidacaoDeposito(Conta conta, BigDecimal deposito){
        BigDecimal saldoAtual = conta.getSaldo();
        BigDecimal valorSaldo = deposito.divide(saldoAtual, RoundingMode.HALF_UP);
        if (valorSaldo.compareTo(new BigDecimal("2.000"))> 0){
            throw new ValidationException(("Valor do Deposito não pode ser súperior a 2.000"));
        }
        BigDecimal saldoReajustado = saldoAtual.add(deposito);
        conta.atualizarSaldo(saldoReajustado);
    }
}
