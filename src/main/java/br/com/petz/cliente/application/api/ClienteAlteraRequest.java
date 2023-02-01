package br.com.petz.cliente.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.petz.cliente.domain.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
@Value
public class ClienteAlteraRequest {
	
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Boolean aceitatermos;
	private LocalDateTime dataMomentoUltimaAlteracao;

}
