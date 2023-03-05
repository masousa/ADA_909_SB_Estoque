package tech.ada.exemplos.salao.beleza.estoque.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tech.ada.exemplos.salao.beleza.estoque.entities.Produto;
import tech.ada.exemplos.salao.beleza.estoque.payload.ProdutoResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoToProdutoResponseMapper {

    public static ProdutoResponse maptoProdutoResponse(Produto produto){
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setNomeProduto(produto.getNome());
        produtoResponse.setQuantidade(produto.getUnidadeEstoque());
        produtoResponse.setMarca(produto.getMarca());
        return produtoResponse;
    }
}
