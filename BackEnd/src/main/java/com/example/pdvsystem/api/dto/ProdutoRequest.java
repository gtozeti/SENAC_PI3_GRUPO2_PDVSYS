package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_produto", "nome", "preco", "quantidade", "empresa"})
public class ProdutoRequest {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("id_produto")
	private Integer id;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("nome")
	private String nome;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("preco")
	private Float preco;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("quantidade")
	private Integer quantidade;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("empresa")
	private EmpresaRequest empresa;

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

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public EmpresaRequest getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaRequest empresa) {
		this.empresa = empresa;
	}
}
