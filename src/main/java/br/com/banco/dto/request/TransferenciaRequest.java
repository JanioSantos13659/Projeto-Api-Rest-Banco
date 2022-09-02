package br.com.banco.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class TransferenciaRequest {


    @Size(min = 4, max = 11, message = "O campo numeroConta deve ter de 4 a 11 posicoes")
    @NotBlank(message = "O campo numeroConta é obrigatório.")
    private String numeroContaOrigem;

    @Size(min = 4, max = 11, message = "O campo numeroConta deve ter de 4 a 11 posicoes")
    @NotBlank(message = "O campo numeroConta é obrigatório.")
    private String numeroContaDestino;

    private Double valorTransferencia;


}


