package tech.ada.exemplos.salao.beleza.estoque.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tech.ada.exemplos.salao.beleza.estoque.exception.ProdutoNotFoundException;
import tech.ada.exemplos.salao.beleza.estoque.mapper.ProdutoToProdutoResponseMapper;
import tech.ada.exemplos.salao.beleza.estoque.payload.ProdutoResponse;
import tech.ada.exemplos.salao.beleza.estoque.repository.ProdutoRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindProdutoByIdentificadorService {

    private final ProdutoRepository produtoRepository;

    public Mono<ProdutoResponse> execute(String identificador){
        log.info("procurando o produto de identificador {}", identificador);
        return Mono.just(identificador)
                .flatMap(produtoRepository::findByIdentificador)
                .switchIfEmpty(Mono.error(ProdutoNotFoundException::new))
                .map(ProdutoToProdutoResponseMapper::maptoProdutoResponse);
    }

}
