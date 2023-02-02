package br.com.petz.pet.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.pet.application.service.PetService;
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

}
