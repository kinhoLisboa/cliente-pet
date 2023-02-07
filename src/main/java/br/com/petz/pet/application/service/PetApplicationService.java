package br.com.petz.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.cliente.application.service.ClienteService;
import br.com.petz.pet.application.api.ListPetResponse;
import br.com.petz.pet.application.api.PetAlteracaoRequest;
import br.com.petz.pet.application.api.PetDetalhadoDoClienteResponse;
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


	@Override
	public PetDetalhadoDoClienteResponse detalhaPetDoCliente(UUID clienteId, UUID petId) {
		log.info("[Inicial] PetApplicationService - detalhaPetDoCliente");
		clienteService.detalha(clienteId);
		Pet pet = petRepository.buscaPet(petId);
		log.info("[Finaliza] PetApplicationService - detalhaPetDoCliente");
		return new PetDetalhadoDoClienteResponse(pet);
	}


	@Override
	public void delelaPetDoCliente(UUID clienteId, UUID petId) {
		log.info("[Inicial] PetApplicationService - delelaPetDoCliente");
		clienteService.detalha(clienteId);
		Pet pet = petRepository.buscaPet(petId);
		 petRepository.deletaPet(pet);
		log.info("[Finaliza] PetApplicationService - delelaPetDoCliente");
	}


	@Override
	public void alteraPetDoCliente(UUID clienteId, UUID petId, @Valid PetAlteracaoRequest petAteracaoRequest) {
		log.info("[Inicial] PetApplicationService - delelaPetDoCliente");
		clienteService.detalha(clienteId);
		Pet pet =	petRepository.buscaPet(petId);
		pet.alteraPet(petAteracaoRequest);
		petRepository.salvaPet(pet);
		log.info("[Finaliza] PetApplicationService - delelaPetDoCliente");
	}
		
	}


	

