package co.com.product.catalog.api;

import co.com.product.catalog.api.commons.util.ResponseUtil;
import co.com.product.catalog.api.dto.ResponseDTO;
import co.com.product.catalog.model.product.Product;
import co.com.product.catalog.usecase.crudproducto.CrudProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
//private  final UseCase useCase;
//private  final UseCase2 useCase2;
    private final CrudProductoUseCase useCase;
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Product.class)
                .switchIfEmpty(Mono.error(new RuntimeException("Error ...")))
                .flatMap(product-> {
                    System.out.printf("Log product %s %s %s \n", product.getId(), product.getName(), product.getClass());
                    return useCase.create(product);
                })
                .map(response -> {
                    System.out.printf("Log product response %s %s %s \n", response.getId(), response.getName(), response.getClass());

                    return ResponseDTO.success(response, serverRequest);
                })
                .flatMap(ResponseUtil::responseOk);
    }
}
