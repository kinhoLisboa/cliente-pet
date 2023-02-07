package br.com.petz.pet.application.api;

import br.com.petz.pet.domain.Porte;
import lombok.Value;

@Value
public class PetAlteracaoRequest {
	
	private Porte porte;
	private String microchip;
	private String rga;
	private String pelagemCor;
	private Integer peso;
}
