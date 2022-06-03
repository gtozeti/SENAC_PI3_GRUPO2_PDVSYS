package com.example.pdvsystem.businessLogic.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.pdvsystem.api.dto.ClienteRequest;
import com.example.pdvsystem.api.dto.ClienteResponse;
import com.example.pdvsystem.businessLogic.model.Cliente;

public class ClienteConverter {

	public static Cliente toCliente(ClienteRequest request) {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(request.getId());
		cliente.setNome(request.getNome());
		cliente.setDocumento(request.getDocumento());
		cliente.setEmail(request.getEmail());
		
		try {
			cliente.setEmpresa(EmpresaConverter.toEmpresa(request.getEmpresa()));
			cliente.setCadastro(InfoCadastroConverter.toInfoCadastro(request.getCadastro()));
		} catch (Exception e) {
			
		}
		
		return cliente;
	}
	
	public static ClienteRequest toClienteRequest(Cliente model) {
		
		ClienteRequest cliente = new ClienteRequest();
		
		cliente.setId(model.getId());
		cliente.setNome(model.getNome());
		cliente.setDocumento(model.getDocumento());
		cliente.setEmail(model.getEmail());
		
		try {
			cliente.setEmpresa(EmpresaConverter.toEmpresaRequest(model.getEmpresa()));
			cliente.setCadastro(InfoCadastroConverter.toInfoCadastroRequest(model.getCadastro()));
		} catch (Exception e) {
			
		}
		
		return cliente;
	}
	
	public static ClienteResponse toClienteResponse(Cliente model) {
		
		ClienteResponse cliente = new ClienteResponse();
		
		cliente.setId(model.getId());
		cliente.setNome(model.getNome());
		cliente.setDocumento(model.getDocumento());
		cliente.setEmail(model.getEmail());
		
		try {
			cliente.setEmpresa(EmpresaConverter.toEmpresaResponse(model.getEmpresa()));
			cliente.setCadastro(InfoCadastroConverter.toInfoCadastroResponse(model.getCadastro()));
		} catch (Exception e) {
			
		}
		
		return cliente;
	}
	
	public static List<ClienteResponse> toListResponse(List<Cliente> listModel) {
		
		List<ClienteResponse> listResponse = new ArrayList<ClienteResponse>();
		
		for (Cliente c : listModel) {
			listResponse.add(toClienteResponse(c));
		}
		
		return listResponse;
	}
}
