package com.example.pdvsystem.businessLogic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pdvsystem.api.dto.ProcessoVendaRequest;
import com.example.pdvsystem.api.dto.VendaResponse;
import com.example.pdvsystem.businessLogic.converter.VendaConverter;
import com.example.pdvsystem.businessLogic.model.Cliente;
import com.example.pdvsystem.businessLogic.model.Empresa;
import com.example.pdvsystem.businessLogic.model.Produto;
import com.example.pdvsystem.businessLogic.model.Usuario;
import com.example.pdvsystem.businessLogic.model.Venda;
import com.example.pdvsystem.dataAccess.ClienteRepository;
import com.example.pdvsystem.dataAccess.EmpresaRepository;
import com.example.pdvsystem.dataAccess.ProdutoRepository;
import com.example.pdvsystem.dataAccess.UsuarioRepository;
import com.example.pdvsystem.dataAccess.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository vendaRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public List<VendaResponse> getAllVendaFromEmpresa(Integer id) {
		
		List<VendaResponse> response = new ArrayList<VendaResponse>();
		
		try {
			response = VendaConverter.toListVendaResponse(vendaRepository.getAllVendaFromEmpresa(id));
		} catch (Exception e) {
			return null;
		}
		
		return response;
	}
	
	public VendaResponse getVendaById(Integer id) {
		VendaResponse response = new VendaResponse();
		
		try {
			response = VendaConverter.toVendaResponse(vendaRepository.getById(id));
		} catch (Exception e) {
			return null;
		}
		
		return response;
	}
	
	public VendaResponse createVenda(ProcessoVendaRequest request) {

		Empresa empresa = new Empresa();
		Usuario usuario = new Usuario();
		Cliente cliente = new Cliente();
		List<Produto> listaProduto = new ArrayList<Produto>();

		try {
			empresa = empresaRepository.getById(request.getEmpresa());
			usuario = usuarioRepository.getById(request.getUsuario());
			cliente = clienteRepository.getById(request.getCliente());
			listaProduto = validateAndGetProduto(request);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

		if (listaProduto == null) {
			return null;
		}
		
		Venda venda = new Venda();
		
		venda.setDataVenda(new Date());
		venda.setMetodoPagamento(request.getMetodoPagamento());
		venda.setValorTotal(request.getValorTotal());
		venda.setEmpresa(empresa);
		venda.setUsuario(usuario);
		venda.setCliente(cliente);
		venda.setListaProduto(listaProduto);
		
		VendaResponse response = new VendaResponse();
		try {
			response = VendaConverter.toVendaResponse(vendaRepository.save(venda));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
		return response;
	}

	private List<Produto> validateAndGetProduto(ProcessoVendaRequest request) {
		
		if (request.getProduto() == null) {
			return null;
		}
		
		if (request.getQuantidade() == null) {
			return null;
		}
		
		if(request.getProduto().size() != request.getQuantidade().size()) {
			return null;
		}
		
		List<Produto> list = new ArrayList<Produto>();
		
		for (int i = 0; i < request.getProduto().size(); i++) {
			Produto p = produtoRepository.getById(request.getProduto().get(i));
			
			if (p.getQuantidade() < request.getQuantidade().get(i)) {
				return null;
			}
			
			p.setQuantidade(p.getQuantidade() - request.getQuantidade().get(i));
			list.add(p);
		}
		
		return list;
	}

	public boolean deleteVenda(Integer vendaId, Integer usuarioId) {
		
		Venda venda = new Venda();
		Usuario usuario = new Usuario();
		
		try {
			
			venda = vendaRepository.getById(vendaId);
			usuario = usuarioRepository.getById(usuarioId);
			
		} catch (Exception e) {
			return false;
		}
		
		if (!usuario.getIsMaster()) {
			return false;
		}
		
		Date today = new Date();
		
		long diffInMillies = Math.abs(today.getTime() - venda.getDataVenda().getTime());
		int diff = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		if (diff > 30) {
			return false;
		}
		
		try {
			vendaRepository.delete(venda);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
