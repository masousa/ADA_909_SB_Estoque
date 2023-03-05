package tech.ada.exemplos.salao.beleza.estoque.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AddProdutoRequest {

    private String nome;
    private String marca;
    private String unidade;
    @JsonProperty("quantidade_unidade")
    private double quantidadeDaUnidade;

    private String identificador;

    @JsonProperty("quantidade")
    private long quantidadeAdicionada;
}
