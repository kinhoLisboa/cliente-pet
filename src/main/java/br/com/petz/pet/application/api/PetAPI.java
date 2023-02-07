package br.com.petz.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{clienteId}/pet")
public interface PetAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PetResponse postPet(@PathVariable UUID clienteId,@Valid @RequestBody PetRequest petRequest);
	
	@GetMapping
	@ResponseStatus(code =HttpStatus.OK)
	List<ListPetResponse> getListPetPorClienteId(@PathVariable UUID clienteId);
	
	@GetMapping(value = "{petId}")
	@ResponseStatus(code =HttpStatus.OK)
	PetDetalhadoDoClienteResponse getPets(@PathVariable  UUID clienteId,@PathVariable  UUID petId);

}
