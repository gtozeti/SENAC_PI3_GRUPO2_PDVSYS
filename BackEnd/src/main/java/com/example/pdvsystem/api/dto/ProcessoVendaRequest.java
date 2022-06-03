package com.example.pdvsystem.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"empresa_id", "usuario_id", "cliente_id", "lista_produto_id", "lista_quantidade","metodo_pagamento", "valor_total"})
public class ProcessoVendaRequest {

	@JsonProperty("empresa_id")
	private Integer empresa;
	
	@JsonProperty("usuario_id")
	private Integer usuario;
	
	@JsonProperty("cliente_id")
	private Integer cliente;
	
	@JsonProperty("lista_produto_id")
	private List<Integer> produto;
	
	@JsonProperty("lista_quantidade")
	private List<Integer> quantidade;
	
	@JsonProperty("metodo_pagamento")
	private String metodoPagamento;
	
	@JsonProperty("valor_total")
	private Float valorTotal;

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public List<Integer> getProduto() {
		return produto;
	}

	public void setProduto(List<Integer> produto) {
		this.produto = produto;
	}

	public List<Integer> getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(List<Integer> quantidade) {
		this.quantidade = quantidade;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
}
