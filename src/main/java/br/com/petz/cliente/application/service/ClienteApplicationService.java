package br.com.petz.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.cliente.application.api.ClienteRequest;
import br.com.petz.cliente.application.api.ClienteResponse;
import br.com.petz.cliente.application.api.ListClienteResponse;
import br.com.petz.cliente.application.repository.ClienteRepository;
import br.com.petz.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	
	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[Inicia] ClienteApplicationService - CriaCliente");
		var cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[Finaliza] ClienteApplicationService - CriaCliente");
		return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
	}

	@Override
	public List<ListClienteResponse> buscaTodosCliente() {
		log.info("[Inicia] ClienteApplicationService - buscaCliente");
		List<Cliente> clientes = clienteRepository.listarClientes();
		log.info("[Finaliza] ClienteApplicationService - Clibuscaente");
		return ListClienteResponse.convert(clientes);
	}

	@Override
	public ClienteDetalhadoResponse detalha(UUID clienteId) {
		log.info("[Inicia] ClienteApiController - detalha");
		Cliente cliente	= clienteRepository.buscaId(clienteId);
		log.info("[Finaliza] ClienteApiController -detalha");
		return new ClienteDetalhadoResponse (cliente);
	}

}
