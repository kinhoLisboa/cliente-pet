package br.com.petz.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.pet.application.api.PetAlteracaoRequest;
import br.com.petz.pet.application.api.PetRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idPet", updatable = false, unique = true, nullable = false)
	private UUID idPet;
	@Column(columnDefinition = "uuid", name = "clienteIdTutor",  nullable = false)
	private UUID clienteIdTutor;
	@NotBlank
	private String nomePet;
	@Enumerated(EnumType.STRING)
	private Porte porte;
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoPet tipo;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private String rga;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private Integer peso;
	private LocalDateTime dataHoraDeCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;
	
	
	public Pet(UUID clienteId, @Valid PetRequest petRequest) {
		
		this.clienteIdTutor = clienteId;
		this.nomePet = petRequest.getNomePet();
		this.porte = petRequest.getPorte();
		this.tipo = petRequest.getTipo();
		this.microchip = petRequest.getMicrochip();
		this.raca = petRequest.getRaca();
		this.sexo = petRequest.getSexo();
		this.rga = petRequest.getRga();
		this.pelagemCor = petRequest.getPelagemCor();
		this.dataNascimento = petRequest.getDataNascimento();
		this.peso = petRequest.getPeso();
		this.dataHoraDeCadastro = LocalDateTime.now();
	
	}


	public void alteraPet(@Valid PetAlteracaoRequest petAteracaoRequest) {
		this.porte = petAteracaoRequest.getPorte();
		this.microchip = petAteracaoRequest.getMicrochip();
		this.rga = petAteracaoRequest.getRga();
		this.pelagemCor = petAteracaoRequest.getPelagemCor();
    	this.peso = petAteracaoRequest.getPeso();
		
	}
	
	
	
}
