package tech.ada.exemplos.salao.beleza.estoque.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import tech.ada.exemplos.salao.beleza.estoque.entities.Produto;
import tech.ada.exemplos.salao.beleza.estoque.mapper.ProdutoToProdutoResponseMapper;
import tech.ada.exemplos.salao.beleza.estoque.payload.ProdutoResponse;
import tech.ada.exemplos.salao.beleza.estoque.repository.ProdutoRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListProdutosService {
    private final ProdutoRepository produtoRepository;

    public Flux<ProdutoResponse> execute(){
        log.info("Executando uma listagem de todos os produtos contidos no banco de dados");
        return produtoRepository.findAll()
                .map(ProdutoToProdutoResponseMapper::maptoProdutoResponse);
    }

}
