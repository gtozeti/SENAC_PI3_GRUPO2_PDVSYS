package com.example.pdvsystem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pdvsystem.api.dto.EmpresaRequest;
import com.example.pdvsystem.api.dto.ProdutoRequest;
import com.example.pdvsystem.api.dto.ProdutoResponse;
import com.example.pdvsystem.businessLogic.service.EmpresaService;
import com.example.pdvsystem.businessLogic.service.ProdutoService;

@RestController
@RequestMapping(value = "/pdv/")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	EmpresaService empresaService;
	
	@CrossOrigin
	@GetMapping(value = "get/produto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoResponse> getProdutoById(@RequestParam(value = "id") Integer id) {
		
		ProdutoResponse response = produtoService.getProdutoByIdResponse(id);
		
		if (response == null) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ProdutoResponse>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@GetMapping(value = "get/produto/all/empresa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProdutoResponse>> getAllProdutoFromEmpresa(@RequestParam(value = "id") Integer id) {
		
		EmpresaRequest empresa = empresaService.getEmpresaByIdRequest(id);
		
		if (empresa == null) {
			return new ResponseEntity<List<ProdutoResponse>>(HttpStatus.NOT_FOUND);
		}
		
		List<ProdutoResponse> response = produtoService.getAllProdutoFromEmpresa(id);
		
		if (response == null) {
			return new ResponseEntity<List<ProdutoResponse>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<ProdutoResponse>>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@PostMapping(value = "post/produto/empresa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoResponse> createProduto(@RequestParam(value = "id") Integer id, @RequestBody ProdutoRequest request) {
		
		EmpresaRequest empresa = empresaService.getEmpresaByIdRequest(id);
		
		if (empresa == null) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.NOT_FOUND);
		}
		
		if (request.getQuantidade() < 0 || request.getPreco() < 0 || request.getPreco() > 50000) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		request.setEmpresa(empresa);
		
		ProdutoResponse response = produtoService.createProduto(request);
		
		if (response == null) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ProdutoResponse>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping(value = "put/produto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoResponse> updateProduto(@RequestParam(value = "id") Integer id, @RequestBody ProdutoRequest request) {
		
		ProdutoRequest produto = produtoService.getProdutoByIdRequest(id);
		
		if (produto == null) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.NOT_FOUND);
		}
		
		request.setId(id);
		request.setEmpresa(produto.getEmpresa());

		ProdutoResponse response = produtoService.createProduto(request);
		
		if (response == null) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ProdutoResponse>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "delete/produto")
	public ResponseEntity<ProdutoResponse> deleteProduto(@RequestParam(value = "id") Integer id) {
		
		ProdutoRequest produto = produtoService.getProdutoByIdRequest(id);
		
		if (produto == null) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.NOT_FOUND);
		}
		
		if (produtoService.deleteProduto(produto)) {
			return new ResponseEntity<ProdutoResponse>(HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<ProdutoResponse>(HttpStatus.BAD_REQUEST);
	}
}
