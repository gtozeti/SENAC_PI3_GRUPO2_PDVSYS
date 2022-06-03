package com.example.pdvsystem.api.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_venda", "data_venda", "metodo_pagamento", "valor_total", "lista_produto", "cliente", "usuario", "empresa"})
public class VendaRequest {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("id_venda")
	private Integer id;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("data_venda")
	private Date dataVenda;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("metodo_pagamento")
	private String metodoPagamento;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("valor_total")
	private Float valorTotal;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("lista_produto")
	private List<ProdutoRequest> listaProduto;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("cliente")
	private ClienteRequest cliente;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("usuario")
	private UsuarioRequest usuario;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	@JsonProperty("empresa")
	private EmpresaRequest empresa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
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

	public List<ProdutoRequest> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<ProdutoRequest> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public ClienteRequest getCliente() {
		return cliente;
	}

	public void setCliente(ClienteRequest cliente) {
		this.cliente = cliente;
	}

	public UsuarioRequest getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRequest usuario) {
		this.usuario = usuario;
	}

	public EmpresaRequest getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaRequest empresa) {
		this.empresa = empresa;
	}
}