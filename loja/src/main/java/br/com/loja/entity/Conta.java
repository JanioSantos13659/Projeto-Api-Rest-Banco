package br.com.loja.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;


@Getter
@Setter
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;
    private BigDecimal saldo;
    private Long numeroConta;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="cliente")
    private Cliente cliente;

    public void atualizarSaldo(BigDecimal novoSaldo){
        this.saldo = novoSaldo;
    }
}
