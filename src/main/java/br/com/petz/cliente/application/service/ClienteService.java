package br.com.petz.cliente.application.service;

import java.util.List;

import br.com.petz.cliente.application.api.ClienteRequest;
import br.com.petz.cliente.application.api.ClienteResponse;
import br.com.petz.cliente.application.api.ListClienteResponse;

public interface ClienteService {

	ClienteResponse criaCliente(ClienteRequest clienteRequest);

	List<ListClienteResponse> buscaTodosCliente();



}
