package br.com.banco.dto.response;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class TransferenciaResponse {

    private String codigoTransferencia;

    private String mensagemTransferencia;



}


