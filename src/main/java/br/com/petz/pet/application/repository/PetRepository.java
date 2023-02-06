package br.com.petz.pet.application.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.pet.domain.Pet;

@Repository
public interface PetRepository {

	Pet salvaPet(Pet pet);

	List<Pet> buscaPetPorClienteId(UUID clienteId);

	

	

}
