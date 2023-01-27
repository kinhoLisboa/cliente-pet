package br.com.petz.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.petz.cliente.domain.Cliente;

public interface ClienteRepository {

	Cliente salva(Cliente cliente);

	List<Cliente> listarClientes();

	Cliente buscaId(UUID clienteId);

}
