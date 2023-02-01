package br.com.petz.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteApi {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ClienteResponse postCliente(@Valid @RequestBody ClienteRequest clienteRequest) ;
		
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ListClienteResponse> getTodosCliente() ;
	
	@GetMapping(value ="/{clienteId}")
	@ResponseStatus(code = HttpStatus.OK)
	ClienteDetalhadoResponse buscarClientePorId(@PathVariable  UUID clienteId) ;
	
	@DeleteMapping(value ="/{clienteId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	 void deletaClientePorId(@PathVariable  UUID clienteId) ;
	
	@PatchMapping(value ="/{clienteId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void petchAlteraCliente(@Valid @RequestBody ClienteAlteraRequest clienteAlteraRequest,@PathVariable  UUID clienteId) ;
}
