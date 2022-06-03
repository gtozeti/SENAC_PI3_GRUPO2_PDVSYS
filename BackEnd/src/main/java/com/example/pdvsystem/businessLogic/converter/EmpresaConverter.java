package com.example.pdvsystem.businessLogic.converter;

import com.example.pdvsystem.api.dto.EmpresaRequest;
import com.example.pdvsystem.api.dto.EmpresaResponse;
import com.example.pdvsystem.businessLogic.model.Empresa;

public class EmpresaConverter {

	public static Empresa toEmpresa(EmpresaRequest request) {
		
		Empresa empresa = new Empresa();
		
		empresa.setId(request.getId());
		empresa.setNome(request.getNome());
		empresa.setDocumento(request.getDocumento());
		
		return empresa;
	}
	
	public static EmpresaRequest toEmpresaRequest(Empresa model) {
		
		EmpresaRequest empresa = new EmpresaRequest();
		
		empresa.setId(model.getId());
		empresa.setNome(model.getNome());
		empresa.setDocumento(model.getDocumento());
		
		return empresa;
	}
	
	public static EmpresaResponse toEmpresaResponse(Empresa model) {
		
		EmpresaResponse empresa = new EmpresaResponse();
		
		empresa.setId(model.getId());
		empresa.setNome(model.getNome());
		empresa.setDocumento(model.getDocumento());
		
		return empresa;
	}
}
