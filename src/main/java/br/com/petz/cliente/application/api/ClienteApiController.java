package br.com.petz.cliente.application.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class ClienteApiController implements ClienteApi {

	
	public ClienteResponse postCliente (ClienteRequest clienteRequest) {
		
		log.info("[Inicial] ClienteController - postCliente");
		log.info("[Finaliza] ClienteController - postCliente");
		
		return null;
	}

}
