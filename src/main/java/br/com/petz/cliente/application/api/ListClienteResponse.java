package br.com.petz.cliente.application.api;

import java.util.List;

import br.com.petz.cliente.domain.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
@Value
public class ListClienteResponse {
	
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String celular;
	private String telefone;
	
	public static List<ListClienteResponse> convert(List<Cliente> clientes) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
