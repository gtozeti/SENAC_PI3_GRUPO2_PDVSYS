package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"senha_atual", "senha_nova"})
public class AlterarSenhaRequest {

	@JsonProperty("senha_atual")
	private String senhaAtual;
	
	@JsonProperty("senha_nova")
	private String senhaNova;

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}
}
