package br.com.petz.pet.application.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.pet.domain.Pet;

public interface PetSpringJpa extends JpaRepository<Pet, UUID>{
      
	List<Pet> findByClienteIdTutor(UUID clienteIdTutor);
}
