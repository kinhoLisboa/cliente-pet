package br.com.petz.pet.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.petz.pet.domain.Pet;
import br.com.petz.pet.domain.Porte;
import br.com.petz.pet.domain.Sexo;
import br.com.petz.pet.domain.TipoPet;
import lombok.Value;
@Value
public class ListPetResponse {
	
	private UUID idPet;
	private String nomePet;
	private Porte porte;
	private TipoPet tipo;
	private String raca;
	private Sexo sexo;
	private String pelagemCor;
	private LocalDate dataNascimento;
	private Integer peso;
	private LocalDateTime dataHoraDeCadastro;
	

	public static List<ListPetResponse> converte(List<Pet> pet) {
	
		return pet.stream()
				.map(ListPetResponse :: new).toList();
			
	}

	public ListPetResponse(Pet pet) {
		
		this.idPet = pet.getIdPet();
		this.nomePet = pet.getNomePet();
		this.porte = pet.getPorte();
		this.tipo = pet.getTipo();
		this.raca = pet.getRaca();
		this.sexo = pet.getSexo();
		this.pelagemCor = pet.getPelagemCor();
		this.dataNascimento = pet.getDataNascimento();
		this.peso = pet.getPeso();
		this.dataHoraDeCadastro = LocalDateTime.now();
	}




}
