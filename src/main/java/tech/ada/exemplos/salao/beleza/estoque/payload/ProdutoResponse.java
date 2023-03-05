package tech.ada.exemplos.salao.beleza.estoque.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProdutoResponse {
    @JsonProperty("nome_produto")
    private String nomeProduto;

    private String marca;

    @JsonProperty("quantidade_estoque")
    private long quantidade;

}
