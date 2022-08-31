package br.com.banco.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class ContaResponse {

    //private Integer idCliente;
    private Integer idConta;
    private ClienteResponse Cliente;
    private String banco;
    private String digito;
    private String NumeroConta;
    private double saldo;


}
