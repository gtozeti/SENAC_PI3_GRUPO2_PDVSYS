package com.example.pdvsystem.businessLogic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdvsystem.api.dto.ProdutoRequest;
import com.example.pdvsystem.api.dto.ProdutoResponse;
import com.example.pdvsystem.businessLogic.converter.ProdutoConverter;
import com.example.pdvsystem.businessLogic.model.Produto;
import com.example.pdvsystem.dataAccess.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public ProdutoResponse getProdutoByIdResponse(Integer id) {
		
		ProdutoResponse response = new ProdutoResponse();
		
		try {
			response = ProdutoConverter.toProdutoResponse(produtoRepository.getById(id));
		} catch (Exception e) {
			return null;
		}
		
		return response;
	}
	
	public ProdutoRequest getProdutoByIdRequest(Integer id) {
		
		ProdutoRequest request = new ProdutoResponse();
		
		try { 
			request = ProdutoConverter.toProdutoRequest(produtoRepository.getById(id));
		} catch (Exception e) {
			return null;
		}
		
		return request;
	}
	
	public List<ProdutoResponse> getAllProdutoFromEmpresa(Integer id) {
		
		List<ProdutoResponse> response = new ArrayList<ProdutoResponse>();
		
		try {
			response = ProdutoConverter.toListProdutoResponse(produtoRepository.getAllProdutosFromEmpresa(id));
		} catch (Exception e) {
			return null;
		}
		
		return response;
	}
	
	public ProdutoResponse createProduto(ProdutoRequest request) {
		
		Produto model = ProdutoConverter.toProduto(request);
		ProdutoResponse response = new ProdutoResponse();
		
		try {
			response = ProdutoConverter.toProdutoResponse(produtoRepository.save(model));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		return response;
	}
	
	public Boolean deleteProduto(ProdutoRequest request) {
		
		try {
			produtoRepository.delete(ProdutoConverter.toProduto(request));
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
