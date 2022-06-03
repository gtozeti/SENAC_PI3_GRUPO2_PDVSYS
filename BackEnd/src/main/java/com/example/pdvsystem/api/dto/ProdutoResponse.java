package com.example.pdvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id_produto", "nome", "preco", "quantidade", "empresa"})
public class ProdutoResponse extends ProdutoRequest {

}
