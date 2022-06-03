package com.example.pdvsystem.businessLogic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdvsystem.api.dto.ClienteRequest;
import com.example.pdvsystem.api.dto.ClienteResponse;
import com.example.pdvsystem.businessLogic.converter.ClienteConverter;
import com.example.pdvsystem.businessLogic.model.Cliente;
import com.example.pdvsystem.dataAccess.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public ClienteResponse getClienteByIdResponse(Integer id) {
		
		ClienteResponse response = new ClienteResponse();
		
		try { 
			Cliente model = clienteRepository.getById(id);
			response = ClienteConverter.toClienteResponse(model);
		} catch (Exception e) {
			return null;
		}
		
		return response;
	}
	
	
	public ClienteRequest getClienteByIdRequest(Integer id) {
		
		ClienteRequest request = new ClienteRequest();
		
		try {
			Cliente model = clienteRepository.getById(id);
			request = ClienteConverter.toClienteRequest(model);
		} catch (Exception e) {
			return null;
		}
		
		return request;
	}
	
	public List<ClienteResponse> getAllClienteFromEmpresa(Integer id) {
		
		List<ClienteResponse> listCliente = new ArrayList<ClienteResponse>();
		
		try {
			listCliente = ClienteConverter.toListResponse(clienteRepository.getAllClienteFromEmpresa(id));
		} catch (Exception e) {
			return null;
		}
		
		return listCliente;
	}
	
	public Boolean documentoExisteNaEmpresa(Integer id, String documento) {
		
		Cliente model = new Cliente();
		
		try {
			model = clienteRepository.documentoExisteAtEmpresa(id, documento);
		} catch (Exception e) { 
			return false;
		}
		
		if (model == null) {
			return false;
		}
		
		return true;
	}
	
	public ClienteResponse createCliente(ClienteRequest request) {
		
		Cliente model = ClienteConverter.toCliente(request);
		
		try {
			return ClienteConverter.toClienteResponse(clienteRepository.save(model));
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean deleteCliente(ClienteRequest request) { 
		
		try {
			clienteRepository.delete(ClienteConverter.toCliente(request));
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
