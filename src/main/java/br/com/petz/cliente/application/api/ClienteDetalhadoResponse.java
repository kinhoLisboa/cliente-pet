package br.com.petz.cliente.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;

import br.com.petz.cliente.domain.Cliente;
import br.com.petz.cliente.domain.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
	
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@CPF
	private String cpf;
	@NotNull
	private Boolean aceitatermos;
	private LocalDateTime dataHoraCadastro;
	
public ClienteDetalhadoResponse(Cliente cliente) {
	
	this.nomeCompleto = cliente.getNomeCompleto();
	this.email = cliente.getEmail();
	this.celular = cliente.getCelular();
	this.telefone = cliente.getTelefone();
	this.sexo = cliente.getSexo();
	this.dataNascimento = cliente.getDataNascimento();
	this.cpf = cliente.getCpf();
	this.aceitatermos = cliente.getAceitatermos();
	this.dataHoraCadastro = cliente.getDataHoraCadastro();
		
	}


}
