package com.example.pdvsystem.businessLogic.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.pdvsystem.api.dto.VendaRequest;
import com.example.pdvsystem.api.dto.VendaResponse;
import com.example.pdvsystem.businessLogic.model.Venda;

public class VendaConverter {

	public static Venda toVenda(VendaRequest request) {

		Venda v = new Venda();

		v.setId(request.getId());
		v.setDataVenda(request.getDataVenda());
		v.setMetodoPagamento(request.getMetodoPagamento());
		v.setValorTotal(request.getValorTotal());
		v.setUsuario(UsuarioConverter.toUsuario(request.getUsuario()));
		v.setCliente(ClienteConverter.toCliente(request.getCliente()));
		v.setEmpresa(EmpresaConverter.toEmpresa(request.getEmpresa()));
		
		try {
			v.setListaProduto(ProdutoConverter.toListProduto(request.getListaProduto()));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return v;
	}

	public static VendaRequest toVendaRequest(Venda model) {

		VendaRequest v = new VendaRequest();

		v.setId(model.getId());
		v.setDataVenda(model.getDataVenda());
		v.setMetodoPagamento(model.getMetodoPagamento());
		v.setValorTotal(model.getValorTotal());
		v.setUsuario(UsuarioConverter.toUsuarioRequest(model.getUsuario()));
		v.setCliente(ClienteConverter.toClienteRequest(model.getCliente()));
		v.setEmpresa(EmpresaConverter.toEmpresaRequest(model.getEmpresa()));
		
		try {
			v.setListaProduto(ProdutoConverter.toListProdutoRequest(model.getListaProduto()));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return v;
	}

	public static VendaResponse toVendaResponse(Venda model) {

		VendaResponse v = new VendaResponse();

		v.setId(model.getId());
		v.setDataVenda(model.getDataVenda());
		v.setMetodoPagamento(model.getMetodoPagamento());
		v.setValorTotal(model.getValorTotal());
		v.setUsuario(UsuarioConverter.toUsuarioResponse(model.getUsuario()));
		v.setCliente(ClienteConverter.toClienteResponse(model.getCliente()));
		v.setEmpresa(EmpresaConverter.toEmpresaResponse(model.getEmpresa()));
		
		try {
			v.setListaProduto(ProdutoConverter.toListProdutoRequest(model.getListaProduto()));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return v;
	}
	
	public static List<VendaResponse> toListVendaResponse(List<Venda> model) {
		
		List<VendaResponse> response = new ArrayList<VendaResponse>();
		
		for (Venda v : model) {
			response.add(toVendaResponse(v));
		}
		
		return response;
	}
}
