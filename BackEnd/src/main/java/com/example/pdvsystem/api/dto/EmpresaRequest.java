package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_empresa", "nome", "documento"})
public class EmpresaRequest {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("id_empresa")
	private Integer id;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("nome")
	private String nome;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("documento")
	private String documento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
