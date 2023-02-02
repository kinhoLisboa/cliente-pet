package br.com.petz.pet.application.api;

import java.time.LocalDate;

import br.com.petz.pet.domain.Porte;
import br.com.petz.pet.domain.Sexo;
import br.com.petz.pet.domain.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
@Value
public class PetRequest {
	
	@NotBlank
	private String nomePet;
	private Porte porte;
	@NotNull
	private TipoPet tipo;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	private Sexo sexo;
	private String rga;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private Integer peso;


}
