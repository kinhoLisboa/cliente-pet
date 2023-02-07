package br.com.petz.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.handler.APIException;
import br.com.petz.pet.application.repository.PetRepository;
import br.com.petz.pet.application.repository.PetSpringJpa;
import br.com.petz.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	
	private final PetSpringJpa petSpringJpa;

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[Inicial] PetInfraRepository - salvaPet ");
		petSpringJpa.save(pet);
		log.info("[Finaliza] PetInfraRepository - salvaPet ");
		return pet;
	}

	@Override
	public List<Pet> buscaPetPorClienteId(UUID clienteId) {
		log.info("[Inicial] PetInfraRepository - buscaPetPorClienteId ");
		var pets = petSpringJpa.findByClienteIdTutor(clienteId);
		log.info("[Finaliza] PetInfraRepository - buscaPetPorClienteId ");
		return pets;
	}

	@Override
	public Pet buscaPet(UUID petId) {
		log.info("[Inicial] PetInfraRepository - buscaPet ");
		var petDoCliente = petSpringJpa.findById(petId)
				.orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND," Id do pet não encontrado" + petId));
		log.info("[Finaliza] PetInfraRepository - buscaPet ");
		return petDoCliente;
	}

	@Override
	public void deletaPet(Pet pet) {
		log.info("[Inicial] PetInfraRepository - deletaPet ");
		petSpringJpa.delete(pet);
		log.info("[Finaliza] PetInfraRepository - deletaPet ");
		
	}





	

}
