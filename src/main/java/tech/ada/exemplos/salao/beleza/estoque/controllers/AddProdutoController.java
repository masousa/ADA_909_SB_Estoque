package tech.ada.exemplos.salao.beleza.estoque.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.ada.exemplos.salao.beleza.estoque.payload.AddProdutoRequest;
import tech.ada.exemplos.salao.beleza.estoque.payload.ProdutoResponse;
import tech.ada.exemplos.salao.beleza.estoque.services.AddProdutoToEstoqueService;
import tech.ada.exemplos.salao.beleza.estoque.services.FindProdutoByIdentificadorService;
import tech.ada.exemplos.salao.beleza.estoque.services.ListProdutosService;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class AddProdutoController {

    private final AddProdutoToEstoqueService addProdutoToEstoqueService;
    private final FindProdutoByIdentificadorService findProdutoByIdentificadorService;

    private final ListProdutosService listProdutosService;

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProdutoResponse> realizarPagamentoFornecedor(@RequestBody AddProdutoRequest addProdutoRequest){

       return addProdutoToEstoqueService.execute(addProdutoRequest);
    }

    @GetMapping(path = "/find/{id}")
    public Mono<ProdutoResponse> getProdutoByIdentificador(@PathVariable("id") String identificador){
        return findProdutoByIdentificadorService.execute(identificador);
    }

    @GetMapping(path = "")
    public Flux<ProdutoResponse> getAllProdutos(){
        return listProdutosService.execute();
    }
}
