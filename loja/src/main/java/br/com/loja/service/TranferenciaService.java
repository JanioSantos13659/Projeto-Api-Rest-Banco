package br.com.loja.service;

import br.com.loja.entity.Conta;
import org.springframework.stereotype.Service;
import javax.validation.ValidationException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TranferenciaService {

    public void validacaoTranferencia(Conta conta, BigDecimal valorTranferencia){
        BigDecimal saldoAtual = conta.getSaldo();
        BigDecimal valorTranfere = valorTranferencia.divide(saldoAtual, RoundingMode.HALF_UP);
        if (valorTranfere.compareTo(saldoAtual) <= 0 ){
            throw new ValidationException(("Não é possivel realizar tranferenica, valor não aceito"));
        }
        BigDecimal saldoReajustado = saldoAtual.add(valorTranfere);
        conta.atualizarSaldo(saldoReajustado);
    }

}
