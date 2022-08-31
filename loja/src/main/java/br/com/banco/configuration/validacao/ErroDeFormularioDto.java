package br.com.loja.configuration.validacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroDeFormularioDto {

    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
