package com.example.pdvsystem.businessLogic.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.pdvsystem.api.dto.ProdutoRequest;
import com.example.pdvsystem.api.dto.ProdutoResponse;
import com.example.pdvsystem.businessLogic.model.Produto;

public class ProdutoConverter {

	public static Produto toProduto(ProdutoRequest request) {
		
		Produto p = new Produto();
		
		p.setId(request.getId());
		p.setNome(request.getNome());
		p.setPreco(request.getPreco());
		p.setQuantidade(request.getQuantidade());
		
		try {
			p.setEmpresa(EmpresaConverter.toEmpresa(request.getEmpresa()));
		} catch (Exception e) {
			
		}
		
		return p;
	}
	
	public static ProdutoRequest toProdutoRequest(Produto model) {
		 
		ProdutoRequest p = new ProdutoRequest();
		
		p.setId(model.getId());
		p.setNome(model.getNome());
		p.setPreco(model.getPreco());
		p.setQuantidade(model.getQuantidade());
		
		try {
			p.setEmpresa(EmpresaConverter.toEmpresaRequest(model.getEmpresa()));
		} catch (Exception e) {
			
		}
		
		return p;
	}
	
	public static ProdutoResponse toProdutoResponse(Produto model) {
		
		ProdutoResponse p = new ProdutoResponse();
		
		p.setId(model.getId());
		p.setNome(model.getNome());
		p.setPreco(model.getPreco());
		p.setQuantidade(model.getQuantidade());
		
		try {
			p.setEmpresa(EmpresaConverter.toEmpresaRequest(model.getEmpresa()));
		} catch (Exception e) {
			
		}
		
		return p;
	}
	
	public static List<ProdutoResponse> toListProdutoResponse(List<Produto> model) {
		
		List<ProdutoResponse> lista = new ArrayList<ProdutoResponse>();
		
		for (Produto p : model) {
			lista.add(toProdutoResponse(p));
		}
		
		return lista;
	}
	
	public static List<Produto> toListProduto(List<ProdutoRequest> model) {
		
		List<Produto> lista = new ArrayList<Produto>();
		
		for (ProdutoRequest p : model) {
			lista.add(toProduto(p));
		}
		
		return lista;
	}
	
	public static List<ProdutoRequest> toListProdutoRequest(List<Produto> model) {
		
		List<ProdutoRequest> lista = new ArrayList<ProdutoRequest>();
		
		for (Produto p : model) {
			lista.add(toProdutoRequest(p));
		}
		
		return lista;
	}
}
