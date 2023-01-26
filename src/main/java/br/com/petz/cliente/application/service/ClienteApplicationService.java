package br.com.petz.cliente.application.service;

import org.springframework.stereotype.Service;

import br.com.petz.cliente.application.api.ClienteRequest;
import br.com.petz.cliente.application.api.ClienteResponse;
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

}
