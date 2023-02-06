package br.com.petz.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.pet.application.api.ListPetResponse;
import br.com.petz.pet.application.api.PetDetalhadoDoClienteResponse;
import br.com.petz.pet.application.api.PetRequest;
import br.com.petz.pet.application.api.PetResponse;
import jakarta.validation.Valid;

@Service
public interface PetService {

	PetResponse criaPet(UUID clienteId, @Valid PetRequest petRequest);

	List<ListPetResponse> buscaPetPorClienteId(UUID clienteId);

	PetDetalhadoDoClienteResponse detalhaPetDoCliente(UUID clienteId, UUID petId);

	

}
