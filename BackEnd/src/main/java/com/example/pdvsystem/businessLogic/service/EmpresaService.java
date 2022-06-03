package com.example.pdvsystem.businessLogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdvsystem.api.dto.EmpresaRequest;
import com.example.pdvsystem.api.dto.EmpresaResponse;
import com.example.pdvsystem.businessLogic.converter.EmpresaConverter;
import com.example.pdvsystem.businessLogic.model.Empresa;
import com.example.pdvsystem.dataAccess.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	public EmpresaRequest getEmpresaByIdRequest(Integer id) {
		EmpresaRequest empresa = new EmpresaRequest();
		
		try {
			empresa = EmpresaConverter.toEmpresaRequest(empresaRepository.getById(id));
		} catch (Exception e) {
			return null;
		}
		
		return empresa;
	}
	
	public EmpresaResponse getEmpresaByIdResponse(Integer id) {
		EmpresaResponse empresa = new EmpresaResponse();
		
		try {
			empresa = EmpresaConverter.toEmpresaResponse(empresaRepository.getById(id));
		} catch (Exception e) {
			return null;
		}
		
		return empresa;
	}
	
	public Boolean documentoExiste(String documento) {
		
		Empresa empresa = new Empresa();
		
		try {
			empresa = empresaRepository.findByDocumento(documento);
		} catch (Exception e) {
			return false;
		}
		
		if (empresa == null) { 
			return false;
		}
		
		return true;
	}
	
	public EmpresaResponse createEmpresa(EmpresaRequest empresa) {
		
		Empresa model = EmpresaConverter.toEmpresa(empresa);
		EmpresaResponse response = new EmpresaResponse();
		
		try {
			response = EmpresaConverter.toEmpresaResponse(empresaRepository.saveAndFlush(model));
		} catch (Exception e) {
			return null;
		}
		
		return response;
	}
	
}
