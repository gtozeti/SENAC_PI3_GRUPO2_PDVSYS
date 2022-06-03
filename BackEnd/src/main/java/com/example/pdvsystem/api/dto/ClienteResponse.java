package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_cliente", "nome", "documento", "email", "empresa", "cadastro"})
public class ClienteResponse extends ClienteRequest {

}
