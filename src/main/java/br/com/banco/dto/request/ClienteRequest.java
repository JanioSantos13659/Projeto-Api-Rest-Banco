package br.com.banco.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class ClienteRequest {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Length(max = 11)
    private String cpf;

}
