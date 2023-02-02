package br.com.petz.pet.infra;

import org.springframework.stereotype.Repository;

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

}
