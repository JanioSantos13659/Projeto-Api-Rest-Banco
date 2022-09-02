package br.com.banco.dto.request;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class ContaRequest {

    private Integer idCliente;

    @Size(min = 3, max = 4, message = "O campo numeroBanco deve ter de 3 a 4 posicoes")
    @NotBlank(message = "O campo numeroBanco é obrigatório.")
    private String banco;

    @Size(min = 4, max = 4, message = "O campo numeroDigito deve ter 4 posicoes")
    @NotBlank(message = "O campo numeroDigito é obrigatório.")
    private String digito;

    @Size(min = 4, max = 11, message = "O campo numeroConta deve ter de 4 a 11 posicoes")
    @NotBlank(message = "O campo numeroConta é obrigatório.")
    private String numeroConta;

}


