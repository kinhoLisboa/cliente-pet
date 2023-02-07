package br.com.petz.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.pet.application.service.PetService;
import br.com.petz.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
	
	private final PetService petService;

	@Override
	public PetResponse postPet(UUID clienteId, @Valid PetRequest petRequest) {
		log.info("[Inicial] PetController - postPet");
		log.info("[IdCliente]{}", clienteId);
		PetResponse pet = petService.criaPet(clienteId, petRequest); 
		log.info("[Finaliza] PetController - postPet");
	
		return pet ;
	}

	@Override
	public List<ListPetResponse> getListPetPorClienteId(UUID clienteId) {
		log.info("[Inicial] PetController - getListPetPorClienteId");
		List<ListPetResponse> listPet = petService.buscaPetPorClienteId(clienteId);
		log.info("[Finaliza] PetController - getListPetPorClienteId");
		return listPet;
	}

	@Override
	public PetDetalhadoDoClienteResponse getPets(UUID clienteId, UUID petId) {
		log.info("[Inicial] PetController - PetDetalhadoDoClienteResponse- getPets");
		PetDetalhadoDoClienteResponse pet = petService.detalhaPetDoCliente(clienteId, petId);
		log.info("[Finaliza] PetController - PetDetalhadoDoClienteResponse- getPets");
		return pet;
	}

	@Override
	public void deletaPetDoCliente(UUID clienteId, UUID petId) {
		log.info("[Inicial] PetController - PetDetalhadoDoClienteResponse- deletaPetDoCliente");
		petService.delelaPetDoCliente(clienteId, petId);
		log.info("[Finaliza] PetController - PetDetalhadoDoClienteResponse- deletaPetDoCliente");
	}

}
