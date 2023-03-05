package tech.ada.exemplos.salao.beleza.estoque.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.ada.exemplos.salao.beleza.estoque.entities.Produto;
import tech.ada.exemplos.salao.beleza.estoque.payload.AddProdutoRequest;
import tech.ada.exemplos.salao.beleza.estoque.payload.ProdutoResponse;
import tech.ada.exemplos.salao.beleza.estoque.repository.ProdutoRepository;

import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class AddProdutoToEstoqueService {

    private final ProdutoRepository produtoRepository;


    public Mono<ProdutoResponse> execute(AddProdutoRequest addProdutoRequest){
        log.info("Chamando ...");
       return retrieveOrSaveProduct(addProdutoRequest).flatMap(this::toProdutoResponse);
    }

    private Mono<ProdutoResponse> toProdutoResponse(Produto produto) {
        ProdutoResponse produtoResponse = new ProdutoResponse();
        produtoResponse.setNomeProduto(produto.getNome());
        produtoResponse.setQuantidade(produto.getUnidadeEstoque());
        produtoResponse.setMarca(produto.getMarca());
        return Mono.just(produtoResponse);
    }

    private  Mono<Produto> retrieveOrSaveProduct(AddProdutoRequest addProdutoRequest) {
        return Mono.just(addProdutoRequest)
                 .flatMap(this::mapToProduto).flatMap(produtoRepository::save);
    }

    private  Mono<Produto> mapToProduto(AddProdutoRequest addProdutoRequest) {
        return  produtoRepository.findByIdentificador(addProdutoRequest.getIdentificador())
                .defaultIfEmpty(this.createProduto(addProdutoRequest))
                .flatMap(produto ->  this.saveOrRetrieve(produto,addProdutoRequest));


    }

    private Produto createProduto(AddProdutoRequest addProdutoRequest) {
        Produto produto = new Produto();
        produto.setNome(addProdutoRequest.getNome());
        produto.setIdentificador(addProdutoRequest.getIdentificador());
        produto.setMarca(addProdutoRequest.getMarca());
        produto.setUnidade(addProdutoRequest.getUnidade());
        produto.setUnidadeEstoque(addProdutoRequest.getQuantidadeAdicionada());
        return produto;
    }

    private Mono<Produto> saveOrRetrieve(Produto produto, AddProdutoRequest addProdutoRequest) {
        log.info("salvando o produto");
        if(Objects.nonNull(produto.getId())){
            produto.setUnidadeEstoque(produto.getUnidadeEstoque()+addProdutoRequest.getQuantidadeAdicionada());

        }
        return Mono.just(produto);

    }
}
