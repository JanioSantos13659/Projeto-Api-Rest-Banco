package br.com.loja.repository;

import br.com.loja.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findBynome(String nome);
}
