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

import com.example.pdvsystem.api.dto.AlterarSenhaRequest;
import com.example.pdvsystem.api.dto.EmpresaRequest;
import com.example.pdvsystem.api.dto.EmpresaResponse;
import com.example.pdvsystem.api.dto.UsuarioRequest;
import com.example.pdvsystem.api.dto.UsuarioResponse;
import com.example.pdvsystem.businessLogic.service.EmpresaService;
import com.example.pdvsystem.businessLogic.service.UsuarioService;

@RestController
@RequestMapping(value = "/pdv/")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	EmpresaService empresaService;
	
	@CrossOrigin
	@GetMapping(value = "/get/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioResponse> getUsuarioById(@RequestParam(value = "id") Integer id) {
		
		UsuarioResponse response = usuarioService.getUsuarioByIdResponse(id);
		
		if (response == null) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UsuarioResponse>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@GetMapping(value = "/get/usuario/all/empresa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioResponse>> getAllUsuarioFromEmpresa(@RequestParam(value = "id") Integer id) {
		
		List<UsuarioResponse> response = usuarioService.getAllUsuarioFromEmpresa(id);
		
		if (response == null) {
			return new ResponseEntity<List<UsuarioResponse>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<UsuarioResponse>>(response, HttpStatus.FOUND);
	}
	
	@CrossOrigin
	@PostMapping(value = "/post/usuario/cadastro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioResponse> createUsuarioCadastro(@RequestBody UsuarioRequest request) {
		
		if (usuarioService.emailExiste(request.getEmail())) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.CONFLICT);
		}
		
		request.setIsMaster(true);
		
		UsuarioResponse response = new UsuarioResponse();
		
		response = usuarioService.createUsuario(request);
		
		return new ResponseEntity<UsuarioResponse>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PostMapping(value = "/post/usuario/cadastro/concluir", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioResponse> createUsuario(@RequestParam(value = "id") Integer id, @RequestBody UsuarioRequest request) {
		
		if (usuarioService.documentoExiste(request.getDocumento())) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.CONFLICT);
		}
		
		if (empresaService.documentoExiste(request.getEmpresa().getDocumento())) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.CONFLICT);
		}
		
		UsuarioRequest usuario = usuarioService.getUsuarioByIdRequest(id);
		
		if (usuario == null) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.NOT_FOUND);
		}
		
		EmpresaResponse empresa = empresaService.createEmpresa(request.getEmpresa());
		
		request.setId(usuario.getId());
		request.setEmail(usuario.getEmail());
		request.setSenha(usuario.getSenha());
		request.setIsMaster(usuario.getIsMaster());
		request.setEmpresa(empresa);
		
		UsuarioResponse response = usuarioService.createUsuario(request);
		
		if (response == null) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<UsuarioResponse>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PostMapping(value = "post/usuario/empresa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioResponse> createUsuarioWithEmpresa(@RequestParam(value = "id") Integer id, @RequestBody UsuarioRequest request) {
		
		EmpresaRequest empresa = empresaService.getEmpresaByIdRequest(id);
		
		if (usuarioService.documentoExiste(request.getDocumento()) || usuarioService.emailExiste(request.getEmail())) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.CONFLICT);
		}
		
		if (empresa == null) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.NOT_FOUND);
		}
		
		request.setEmpresa(empresa);
		
		UsuarioResponse response = usuarioService.createUsuario(request);
		
		if (response == null) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UsuarioResponse>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PostMapping(value = "post/usuario/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioResponse> validacaoLogin(@RequestBody UsuarioRequest request) {
		
		if(!usuarioService.emailExiste(request.getEmail())) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.NOT_FOUND);
		}
		
		if (usuarioService.verificaLogin(request)) {
			return new ResponseEntity<UsuarioResponse>(usuarioService.getUsuarioByEmail(request.getEmail()), HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<UsuarioResponse>(HttpStatus.BAD_REQUEST);
	}
	
	@CrossOrigin
	@PutMapping(value = "put/usuario/cadastro")
	public ResponseEntity<UsuarioResponse> atualizarUsuario(@RequestParam(value = "id") Integer id, @RequestBody UsuarioRequest request) {
		
		UsuarioRequest usuario = usuarioService.getUsuarioByIdRequest(id);
		
		if(usuarioService.emailExiste(request.getEmail()) && !usuario.getEmail().equals(request.getEmail())) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.CONFLICT);
		}
		
		if(usuarioService.documentoExiste(request.getDocumento()) && !usuario.getDocumento().equals(request.getDocumento()) ) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.CONFLICT);
		}
		
		request.setId(id);
		
		UsuarioResponse response = usuarioService.createUsuario(request);
		
		return new ResponseEntity<UsuarioResponse>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PutMapping(value = "put/usuario/senha")
	public ResponseEntity<UsuarioResponse> alterarSenha(@RequestParam(value = "id") Integer id, @RequestBody AlterarSenhaRequest request) {
		
		UsuarioRequest usuario = usuarioService.getUsuarioByIdRequest(id);
		
		if (usuario == null) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.NOT_FOUND);
		}
		
		if (!usuario.getSenha().equals(request.getSenhaAtual())) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.BAD_REQUEST);
		}
		
		usuario.setSenha(request.getSenhaNova());
		
		UsuarioResponse response = usuarioService.createUsuario(usuario);
		
		return new ResponseEntity<UsuarioResponse>(response, HttpStatus.ACCEPTED);
		
	}
	
	@CrossOrigin
	@DeleteMapping(value = "delete/usuario")
	public ResponseEntity<UsuarioResponse> deleteUsuario(@RequestParam(value = "id") Integer id) {
		
		UsuarioRequest usuario = usuarioService.getUsuarioByIdRequest(id);
		
		if (usuario == null) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.NOT_FOUND);
		}
		
		if(usuarioService.deleteUsuario(usuario)) {
			return new ResponseEntity<UsuarioResponse>(HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<UsuarioResponse>(HttpStatus.BAD_REQUEST);
	}
}
