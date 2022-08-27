package br.com.loja.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nome;
    private String cpf;

    @JsonIgnore
    @OneToOne(mappedBy ="cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Conta conta;

    public Cliente(){}

    public Cliente(String cpf, String nome, Cliente cliente) {
        this.nome = nome;
        this.cpf = cpf;
        cliente = cliente;
    }
}
