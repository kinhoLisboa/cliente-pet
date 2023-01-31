package br.com.petz.cliente.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.cliente.application.api.ClienteRequest;
import br.com.petz.cliente.application.api.ClienteResponse;
import br.com.petz.cliente.application.api.ListClienteResponse;

public interface ClienteService {



	ClienteResponse criaCliente(ClienteRequest clienteRequest);

	List<ListClienteResponse> buscaTodosCliente();
	
	ClienteDetalhadoResponse detalha(UUID clienteId);

	void excluirClienteId(UUID clienteId);



}
