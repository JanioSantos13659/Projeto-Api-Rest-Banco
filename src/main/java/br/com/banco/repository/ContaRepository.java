package br.com.banco.repository;


import br.com.banco.entity.Conta;
import org.springframework.data.repository.CrudRepository;


public interface ContaRepository extends CrudRepository<Conta, Integer> {

    Conta findByNumeroConta(String numeroConta);


}
