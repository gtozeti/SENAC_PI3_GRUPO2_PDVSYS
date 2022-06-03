package com.example.pdvsystem.businessLogic.converter;

import com.example.pdvsystem.api.dto.InfoCadastroRequest;
import com.example.pdvsystem.api.dto.InfoCadastroResponse;
import com.example.pdvsystem.businessLogic.model.InfoCadastro;

public class InfoCadastroConverter {

	public static InfoCadastro toInfoCadastro(InfoCadastroRequest request) {
		
		InfoCadastro cadastro = new InfoCadastro();
		
		cadastro.setId(request.getId());
		cadastro.setLogradouro(request.getLogradouro());
		cadastro.setNumero(request.getNumero());
		cadastro.setComplemento(request.getComplemento());
		cadastro.setBairro(request.getBairro());
		cadastro.setCidade(request.getCidade());
		cadastro.setEstado(request.getEstado());
		cadastro.setCep(request.getCep());
		
		return cadastro;
	}
	
	public static InfoCadastroRequest toInfoCadastroRequest(InfoCadastro model) {
		
		InfoCadastroRequest cadastro = new InfoCadastroRequest();
		
		cadastro.setId(model.getId());
		cadastro.setLogradouro(model.getLogradouro());
		cadastro.setNumero(model.getNumero());
		cadastro.setComplemento(model.getComplemento());
		cadastro.setBairro(model.getBairro());
		cadastro.setCidade(model.getCidade());
		cadastro.setEstado(model.getEstado());
		cadastro.setCep(model.getCep());
		
		return cadastro;
	}
	
	public static InfoCadastroResponse toInfoCadastroResponse(InfoCadastro model) {
		
		InfoCadastroResponse cadastro = new InfoCadastroResponse();
		
		cadastro.setId(model.getId());
		cadastro.setLogradouro(model.getLogradouro());
		cadastro.setNumero(model.getNumero());
		cadastro.setComplemento(model.getComplemento());
		cadastro.setBairro(model.getBairro());
		cadastro.setCidade(model.getCidade());
		cadastro.setEstado(model.getEstado());
		cadastro.setCep(model.getCep());
		
		return cadastro;
	}
	
}
