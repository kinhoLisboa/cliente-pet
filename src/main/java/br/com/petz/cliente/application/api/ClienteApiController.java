package br.com.petz.cliente.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteApiController implements ClienteApi {
	
	
	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente (ClienteRequest clienteRequest) {
		
		log.info("[Inicial] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[Finaliza] ClienteController - postCliente");
		
		return clienteCriado;
	}

	@Override
	public List<ListClienteResponse> getTodosCliente() {
		log.info("[Inicia] ClienteApiController - GetTodosCliente");
		 List<ListClienteResponse> clientes = clienteService.buscaTodosCliente();
		log.info("[Finaliza]ClienteApiController - GetTodosCliente");
		return clientes;
	}

}
