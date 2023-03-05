package tech.ada.exemplos.salao.beleza.estoque.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import tech.ada.exemplos.salao.beleza.estoque.entities.Produto;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, String> {
    Mono<Produto> findByIdentificador(String identificador);
}
