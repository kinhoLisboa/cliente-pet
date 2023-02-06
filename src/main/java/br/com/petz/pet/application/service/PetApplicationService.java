package br.com.petz.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.cliente.application.service.ClienteService;
import br.com.petz.pet.application.api.ListPetResponse;
import br.com.petz.pet.application.api.PetRequest;
import br.com.petz.pet.application.api.PetResponse;
import br.com.petz.pet.application.repository.PetRepository;
import br.com.petz.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	
	private final ClienteService clienteService;
	private final PetRepository petRepository;
	

	@Override
	public PetResponse criaPet(UUID clienteId, @Valid PetRequest petRequest) {
		log.info("[Inicial] PetApplicationService - criaPet");
		clienteService.detalha(clienteId);
		Pet pet = petRepository.salvaPet(new Pet(clienteId, petRequest));
		log.info("[Finaliza] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());

	}


	@Override
	public List<ListPetResponse> buscaPetPorClienteId(UUID clienteId) {
		    log.info("[Inicial] PetApplicationService - buscaPetPorClienteId");
		    clienteService.detalha(clienteId);
			List<Pet> pet = petRepository.buscaPetPorClienteId(clienteId);
			log.info("[Finaliza] PetApplicationService - buscaPetPorClienteId");
			return ListPetResponse.converte( pet);
		}
		
	}


	

