package tech.ada.exemplos.salao.beleza.estoque.controllers;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tech.ada.exemplos.salao.beleza.estoque.payload.HelloResponse;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping(path = "/hello", produces = "application/json")
    @ApiResponse(description = "Say Hello")
    public Mono<HelloResponse> getHelloResponse(){
        return  Mono.just(HelloResponse.builder().text("Hello").build());
    }
}
