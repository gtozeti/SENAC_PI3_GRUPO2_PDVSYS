package com.example.pdvsystem.businessLogic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdvsystem.api.dto.UsuarioRequest;
import com.example.pdvsystem.api.dto.UsuarioResponse;
import com.example.pdvsystem.businessLogic.converter.UsuarioConverter;
import com.example.pdvsystem.businessLogic.model.Usuario;
import com.example.pdvsystem.dataAccess.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public UsuarioResponse getUsuarioByIdResponse(Integer id) {
		
		UsuarioResponse response = new UsuarioResponse();
		
		try {
			Usuario model = usuarioRepository.getById(id);
			response = UsuarioConverter.toUsuarioResponse(model);
		} catch (Exception e) {
			return null;
		}
		
		return response;
	}
	
	public UsuarioResponse getUsuarioByEmail(String email) {
		
		return UsuarioConverter.toUsuarioResponse(usuarioRepository.findByEmail(email));
	}
	
	public List<UsuarioResponse> getAllUsuarioFromEmpresa(Integer id) {
		
		List<UsuarioResponse> listaUsuario = new ArrayList<UsuarioResponse>();
		
		try {
			listaUsuario = UsuarioConverter.toListUsuarioResponse(usuarioRepository.findUsuarioByEmpresaId(id));
		} catch (Exception e) {
			return null;
		}
		
		return listaUsuario;
	}
	
	public UsuarioRequest getUsuarioByIdRequest(Integer id) {
		
		UsuarioRequest request = new UsuarioRequest();
		
		try {
			Usuario model = usuarioRepository.getById(id);
			request = UsuarioConverter.toUsuarioRequest(model);
		} catch (Exception e) {
			return null;
		}
		
		return request;
	}
	
	public UsuarioResponse createUsuario(UsuarioRequest request) {
		
		Usuario model = UsuarioConverter.toUsuario(request);
		
		try {
			return UsuarioConverter.toUsuarioResponse(usuarioRepository.save(model));
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean emailExiste(String email) {
		
		Usuario usuario = new Usuario();
		
		try {
			usuario = usuarioRepository.findByEmail(email);
		} catch (Exception e) {
			return false;
		}
		
		if (usuario == null) {
			return false;
		}
		
		return true;
	}
	
	public Boolean documentoExiste(String documento) {
		
		Usuario usuario = new Usuario();
		
		try {
			usuario = usuarioRepository.findByDocumento(documento);
		} catch (Exception e) {
			return false;
		}
		
		if (usuario == null) {
			return false;
		}
		
		return true;
	}
	
	public Boolean verificaLogin(UsuarioRequest request) {
		
		Usuario usuario = new Usuario();
		
		try {
			usuario = usuarioRepository.findByEmail(request.getEmail());
		} catch (Exception e) {
			return false;
		}
		
		if (usuario.getEmail().equals(request.getEmail()) && usuario.getSenha().equals(request.getSenha())) {
			return true;
		}
		
		return false;
	}
	
	public Boolean deleteUsuario(UsuarioRequest request) {
		
		try {
			usuarioRepository.delete(UsuarioConverter.toUsuario(request));
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
}
