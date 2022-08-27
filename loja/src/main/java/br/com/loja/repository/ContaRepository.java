package br.com.loja.repository;


import br.com.loja.entity.Cliente;
import br.com.loja.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
