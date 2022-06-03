package com.example.pdvsystem.businessLogic.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.pdvsystem.api.dto.UsuarioRequest;
import com.example.pdvsystem.api.dto.UsuarioResponse;
import com.example.pdvsystem.businessLogic.model.Usuario;

public class UsuarioConverter {

	public static Usuario toUsuario(UsuarioRequest request) {

		Usuario usuario = new Usuario();

		usuario.setId(request.getId());
		usuario.setNome(request.getNome());
		usuario.setDocumento(request.getDocumento());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(request.getSenha());
		usuario.setIsMaster(request.getIsMaster());

		try {
			usuario.setEmpresa(EmpresaConverter.toEmpresa(request.getEmpresa()));
			usuario.setCadastro(InfoCadastroConverter.toInfoCadastro(request.getCadastro()));
		} catch (Exception e) {
			
		}

		return usuario;
	}

	public static UsuarioRequest toUsuarioRequest(Usuario model) {

		UsuarioRequest usuario = new UsuarioRequest();

		usuario.setId(model.getId());
		usuario.setNome(model.getNome());
		usuario.setDocumento(model.getDocumento());
		usuario.setEmail(model.getEmail());
		usuario.setSenha(model.getSenha());
		usuario.setIsMaster(model.getIsMaster());

		try {
			usuario.setEmpresa(EmpresaConverter.toEmpresaRequest(model.getEmpresa()));
			usuario.setCadastro(InfoCadastroConverter.toInfoCadastroRequest(model.getCadastro()));
		} catch (Exception e) {
			
		}

		return usuario;
	}

	public static UsuarioResponse toUsuarioResponse(Usuario model) {

		UsuarioResponse usuario = new UsuarioResponse();

		usuario.setId(model.getId());
		usuario.setNome(model.getNome());
		usuario.setDocumento(model.getDocumento());
		usuario.setEmail(model.getEmail());
		usuario.setSenha(model.getSenha());
		usuario.setIsMaster(model.getIsMaster());

		try {
			usuario.setEmpresa(EmpresaConverter.toEmpresaRequest(model.getEmpresa()));
			usuario.setCadastro(InfoCadastroConverter.toInfoCadastroRequest(model.getCadastro()));
		} catch (Exception e) {
			
		}

		return usuario;
	}
	
	public static List<UsuarioResponse> toListUsuarioResponse(List<Usuario> listaModel) {
		
		List<UsuarioResponse> listaResponse = new ArrayList<UsuarioResponse>();
		
		for (Usuario u : listaModel) {
			System.out.println(u.getNome());
			listaResponse.add(toUsuarioResponse(u));
		}
		
		return listaResponse;
	}

}
