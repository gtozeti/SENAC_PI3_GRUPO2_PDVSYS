package com.example.pdvsystem.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pdvsystem.api.dto.ProcessoVendaRequest;
import com.example.pdvsystem.api.dto.VendaResponse;
import com.example.pdvsystem.businessLogic.service.VendaService;

@RestController
@RequestMapping(value = "/pdv/")
public class VendaController {

	@Autowired
	VendaService vendaService;

	@CrossOrigin
	@GetMapping(value = "get/venda/all/empresa")
	public ResponseEntity<List<VendaResponse>> getAllVendaFromEmpresa(@RequestParam(value = "id") Integer id) {

		List<VendaResponse> response = new ArrayList<VendaResponse>();

		response = vendaService.getAllVendaFromEmpresa(id);

		if (response == null) {
			return new ResponseEntity<List<VendaResponse>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<VendaResponse>>(response, HttpStatus.FOUND);

	}

	@CrossOrigin
	@GetMapping(value = "get/venda")
	public ResponseEntity<VendaResponse> getVendaById(@RequestParam(value = "id") Integer id) {

		VendaResponse response = new VendaResponse();

		response = vendaService.getVendaById(id);
		
		if (response == null) {
			return new ResponseEntity<VendaResponse>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<VendaResponse>(response, HttpStatus.FOUND);
	}

	
	@CrossOrigin
	@PostMapping(value = "post/venda")
	public ResponseEntity<VendaResponse> criarVenda(@RequestBody ProcessoVendaRequest request) {

		VendaResponse response = new VendaResponse();

		response = vendaService.createVenda(request);

		if (response == null) {
			return new ResponseEntity<VendaResponse>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<VendaResponse>(response, HttpStatus.CREATED);
	}
}
