package br.com.petz.cliente.application.infra;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.petz.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
	
	private final ClienteSpringDataJpa clienteSpringDataJpa;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[Inicia] ClienteInfraRepository - salvar");
		clienteSpringDataJpa.save(cliente);
		log.info("[Finaliza] ClienteInfraRepository - salvar");
		
		return cliente;
	}

	@Override
	public List<Cliente>  listarClientes() {
		log.info("[Inicia] ClienteInfraRepository - buscar");
		var clientes = clienteSpringDataJpa.findAll();
		log.info("[Finaliza] ClienteInfraRepository - buscar");
		return clientes ;
		
		
	}

}
