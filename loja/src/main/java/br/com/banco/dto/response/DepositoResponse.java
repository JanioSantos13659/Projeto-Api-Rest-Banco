package br.com.banco.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class DepositoResponse {

    private String codigoDeposito;

    private String mensagemDeposito;

}
