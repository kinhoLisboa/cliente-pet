package br.com.petz.pet.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.pet.domain.Porte;
import br.com.petz.pet.domain.Sexo;
import br.com.petz.pet.domain.TipoPet;
import lombok.Value;

@Value
public class PetDetalhadoDoClienteResponse {
	
	private UUID idPet;
	private UUID clienteIdTutor;
	private String nomePet;
	private Porte porte;	
	private TipoPet tipo;
	private String microchip;
	private String raca;
	private Sexo sexo;
	private String rga;
	private String pelagemCor;
	private LocalDate dataNascimento;
	private Integer peso;
	private LocalDateTime dataHoraDeCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;
}
