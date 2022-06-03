package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_venda", "metodo_pagamento", "valor_total", "lista_produto", "cliente", "usuario", "empresa"})
public class VendaResponse extends VendaRequest {

}
