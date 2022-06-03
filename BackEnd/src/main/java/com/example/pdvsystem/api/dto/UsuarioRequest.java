package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_usuario", "nome", "documento", "email", "senha", "is_master", "empresa", "cadastro"})
public class UsuarioRequest {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("id_usuario")
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
	@JsonProperty("senha")
	private String senha;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("is_master")
	private Boolean isMaster;
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsMaster() {
		return isMaster;
	}

	public void setIsMaster(Boolean isMaster) {
		this.isMaster = isMaster;
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
