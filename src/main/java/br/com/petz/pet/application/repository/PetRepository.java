package br.com.petz.pet.application.repository;

import org.springframework.stereotype.Repository;

import br.com.petz.pet.domain.Pet;

@Repository
public interface PetRepository {

	Pet salvaPet(Pet pet);

}
