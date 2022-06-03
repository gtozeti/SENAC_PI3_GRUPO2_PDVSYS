package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_cliente", "nome", "documento", "email", "empresa", "cadastro"})
public class ClienteRequest {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("id_cliente")
	private Integer id;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("nome")
	private String nome;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("documento")
	private String documento;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("email")
	private String email;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("empresa")
	private EmpresaRequest empresa;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("cadastro")
	private InfoCadastroRequest cadastro;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmpresaRequest getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaRequest empresa) {
		this.empresa = empresa;
	}

	public InfoCadastroRequest getCadastro() {
		return cadastro;
	}

	public void setCadastro(InfoCadastroRequest cadastro) {
		this.cadastro = cadastro;
	}
}
