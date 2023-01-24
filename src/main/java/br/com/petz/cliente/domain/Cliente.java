package br.com.petz.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Cliente {
	
	private Long idCliente;
	
	@NotBlank
	private String nomeCompelto;
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
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataMomentoUltimaAlteracao;
	
	@NotBlank
	private Boolean aceitatermos;
	
	
	public Cliente(@NotBlank String nomeCompelto, @NotBlank @Email String email, @NotBlank String celular,
			String telefone, Sexo sexo, @NotNull LocalDate dataNascimento, @CPF String cpf,
			LocalDateTime dataHoraCadastro, @NotBlank Boolean aceitatermos) {
		super();
		this.idCliente = idCliente;
		this.nomeCompelto = nomeCompelto;
		this.email = email;
		this.celular = celular;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.dataHoraCadastro = LocalDateTime.now();
		this.aceitatermos = aceitatermos;
	}
	
	
	
	
	

}
