package br.com.loja.dto.response;

import br.com.loja.entity.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class ContaDto {

    private Integer idCliente;
    private BigDecimal saldo;
    private Long numeroConta;

    public ContaDto(Conta conta){
        this.idCliente = getIdCliente();
        this.saldo = getSaldo();
        this.numeroConta = getNumeroConta();
    }
    public static List<ContaDto> conveterDto(List<Conta> contas) {
        return contas.stream().map(ContaDto::new).collect(Collectors.toList());
    }
}
