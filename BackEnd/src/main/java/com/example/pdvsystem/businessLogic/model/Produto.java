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
@Table(name = "PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "PRECO")
	private Float preco;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	@ManyToOne(targetEntity = Empresa.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private Empresa empresa;
	
//	@ManyToMany(mappedBy = "listaProduto", cascade = CascadeType.MERGE)
//	private List<Venda> listaVenda = new ArrayList<Venda>();

	// ================================================== //
	
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

	// ================================================== //
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

//	public List<Venda> getListaVenda() {
//		return listaVenda;
//	}
//
//	public void setListaVenda(List<Venda> listaVenda) {
//		this.listaVenda = listaVenda;
//	}
}
