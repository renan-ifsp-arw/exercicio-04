package br.edu.ifsp.dw2.exercicio04.repository;

import br.edu.ifsp.dw2.exercicio04.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
