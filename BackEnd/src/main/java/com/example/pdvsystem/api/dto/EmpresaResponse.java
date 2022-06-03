package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_empresa", "nome", "documento"})
public class EmpresaResponse extends EmpresaRequest {

}
