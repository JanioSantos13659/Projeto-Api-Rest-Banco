package br.com.banco.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
public class DepositoRequest {

    @Positive
    private Double valorDeposito;

    @Size(min = 4, max = 11, message = "O campo numeroContaDeposito deve ter de 4 a 11 posicoes")
    @NotBlank(message = "O campo numeroContaDeposito é obrigatório.")
    private String numeroContaDeposito;

    //private double saldoAtual;
}
