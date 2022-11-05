package co.com.product.catalog.usecase.crudproducto;

import co.com.product.catalog.model.product.Product;
import co.com.product.catalog.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class CrudProductoUseCase {

    private final ProductRepository productRepository;

    public Mono<Product> create(Product product) {
        return productRepository.create(product);
    }

    public Flux<Product> findAll() {

        return productRepository.findAll();
    }
}
