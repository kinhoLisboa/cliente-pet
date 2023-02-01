package br.com.petz.pet.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
public class PetController implements PetAPI {

	@Override
	public PetResponse postPet(UUID clienteId, @Valid PetRequest petRequest) {
		log.info("[Inicial] PetController - postPet");
		log.info("[IdCliente]{}", clienteId);
		log.info("[Finaliza] PetController - postPet");
	
		return null;
	}

}
