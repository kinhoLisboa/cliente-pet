package br.com.petz.cliente.application.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.cliente.domain.Cliente;

public interface ClienteSpringDataJpa extends JpaRepository<Cliente, UUID>{

}
