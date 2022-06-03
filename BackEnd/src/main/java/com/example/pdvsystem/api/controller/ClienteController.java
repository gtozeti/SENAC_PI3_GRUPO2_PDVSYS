package com.example.pdvsystem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.pdvsystem.api.dto.ClienteRequest;
import com.example.pdvsystem.api.dto.ClienteResponse;
import com.example.pdvsystem.api.dto.EmpresaRequest;
import com.example.pdvsystem.businessLogic.service.ClienteService;
import com.example.pdvsystem.businessLogic.service.EmpresaService;

@RestController
@RequestMapping(value = "/pdv/")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	EmpresaService empresaService;

	@CrossOrigin
	@GetMapping(value = "/get/cliente")
	public ResponseEntity<ClienteResponse> getClienteById(@RequestParam(value = "id") Integer id) {

		ClienteResponse response = clienteService.getClienteByIdResponse(id);

		if (response == null) {
			return new ResponseEntity<ClienteResponse>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ClienteResponse>(response, HttpStatus.FOUND);
	}

	@CrossOrigin
	@GetMapping(value = "/get/cliente/all/empresa")
	public ResponseEntity<List<ClienteResponse>> gettAllClienteFromEmpresa(@RequestParam(value = "id") Integer id) {

		List<ClienteResponse> response = clienteService.getAllClienteFromEmpresa(id);

		if (response == null) {
			return new ResponseEntity<List<ClienteResponse>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<ClienteResponse>>(response, HttpStatus.FOUND);
	}

	@CrossOrigin
	@PostMapping(value = "/post/cliente/empresa")
	public ResponseEntity<ClienteResponse> createCliente(@RequestParam(value = "id") Integer id,
			@RequestBody ClienteRequest request) {

		EmpresaRequest empresa = empresaService.getEmpresaByIdRequest(id);

		if (empresa == null) {
			return new ResponseEntity<ClienteResponse>(HttpStatus.NOT_FOUND);
		}

		if (clienteService.documentoExisteNaEmpresa(id, request.getDocumento())) {
			return new ResponseEntity<ClienteResponse>(HttpStatus.CONFLICT);
		}

		request.setEmpresa(empresa);

		ClienteResponse response = clienteService.createCliente(request);

		return new ResponseEntity<ClienteResponse>(response, HttpStatus.CREATED);
	}

	@CrossOrigin
	@PutMapping(value = "put/cliente")
	public ResponseEntity<ClienteResponse> updateCliente(@RequestParam(value = "id") Integer id,
			@RequestBody ClienteRequest request) {

		ClienteRequest cliente = clienteService.getClienteByIdRequest(id);

		if (cliente == null) {
			return new ResponseEntity<ClienteResponse>(HttpStatus.NOT_FOUND);
		}

		if (clienteService.documentoExisteNaEmpresa(cliente.getEmpresa().getId(), cliente.getDocumento())
				&& !cliente.getEmail().equals(request.getEmail())) {

			return new ResponseEntity<ClienteResponse>(HttpStatus.CONFLICT);
		}

		request.setId(id);
		request.setEmpresa(cliente.getEmpresa());

		ClienteResponse response = clienteService.createCliente(request);

		return new ResponseEntity<ClienteResponse>(response, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ClienteResponse> alterarSenha(@RequestParam(value = "id") Integer id, @RequestBody ClienteRequest request) {
		
		ClienteRequest cliente = clienteService.getClienteByIdRequest(id);
		
		if (cliente == null) {
			return new ResponseEntity<ClienteResponse>(HttpStatus.NOT_FOUND);
		}
		
		return null;
	}

	@CrossOrigin
	@DeleteMapping(value = "delete/cliente")
	public ResponseEntity<ClienteResponse> deleteCliente(@RequestParam(value = "id") Integer id) {

		ClienteRequest cliente = clienteService.getClienteByIdRequest(id);

		if (cliente == null) {
			return new ResponseEntity<ClienteResponse>(HttpStatus.NOT_FOUND);
		}
		
		if (clienteService.deleteCliente(cliente)) {
			return new ResponseEntity<ClienteResponse>(HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<ClienteResponse>(HttpStatus.BAD_REQUEST);
	}
}
