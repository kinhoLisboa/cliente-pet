package br.com.petz.pet.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.pet.application.api.PetRequest;
import br.com.petz.pet.application.api.PetResponse;
import jakarta.validation.Valid;

@Service
public interface PetService {

	PetResponse criaPet(UUID clienteId, @Valid PetRequest petRequest);

}
