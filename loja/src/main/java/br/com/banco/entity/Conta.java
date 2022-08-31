package br.com.banco.entity;

import lombok.*;

import javax.persistence.*;



@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;
    private String banco;
    private String digito;
    @Column(unique=true)
    private String numeroConta;
    private double saldo;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="idCliente")
    private Cliente cliente;

}
