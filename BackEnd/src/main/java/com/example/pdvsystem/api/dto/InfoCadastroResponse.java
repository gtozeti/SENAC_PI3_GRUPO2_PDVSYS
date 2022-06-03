package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_cadastro", "logradouro", "numero", "complemento", "bairro", "cidade", "estado", "cep"})
public class InfoCadastroResponse extends InfoCadastroRequest {

}
