package com.example.pdvsystem.businessLogic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DOCUMENTO", unique = true)
	private String documento;
	
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "IS_MASTER")
	private Boolean isMaster;
	
	@ManyToOne(targetEntity = Empresa.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	private Empresa empresa;
	
	@ManyToOne(targetEntity = InfoCadastro.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private InfoCadastro cadastro;
	
	// ============================================================== //
	
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

	// ============================================================== //
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public InfoCadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(InfoCadastro cadastro) {
		this.cadastro = cadastro;
	}
}
