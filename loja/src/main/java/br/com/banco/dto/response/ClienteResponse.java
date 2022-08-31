package br.com.banco.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteResponse {

    @NotNull
    private Integer idCliente;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Length(max = 11)
    private String cpf;
}
