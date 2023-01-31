package br.com.petz.cliente.application.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente.domain.Cliente;
import br.com.petz.handler.APIException;
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
		try {
			clienteSpringDataJpa.save(cliente);
			
		}catch(DataIntegrityViolationException e){
			throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
			
		}
		
		log.info("[Finaliza] ClienteInfraRepository - salvar");
		
		return cliente;
	}

	@Override
	public List<Cliente>  listarClientes() {
		log.info("[Inicia] ClienteInfraRepository - listar");
		var clientes = clienteSpringDataJpa.findAll();
		log.info("[Finaliza] ClienteInfraRepository - listar");
		return clientes ;
		
		
	}

	@Override
	public Cliente buscaId(UUID clienteId) {
		log.info("[Inicia] ClienteInfraRepository - buscar");
		Cliente cliente =  clienteSpringDataJpa.findById(clienteId)
				.orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
		log.info("[Finaliza] ClienteInfraRepository - buscar");
		return cliente;
	}

	@Override
	public void deletaCliente(Cliente cliente) {
		log.info("[Inicia] ClienteApiController - deletaCliente");
		clienteSpringDataJpa.delete(cliente);
		log.info("[Finaliza] ClienteApiController - deletaCliente");
		
	}

	

}
