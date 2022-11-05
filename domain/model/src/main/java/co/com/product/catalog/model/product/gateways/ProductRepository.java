package co.com.product.catalog.model.product.gateways;

import co.com.product.catalog.model.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> create(Product product);
    Flux<Product> findAll();
}
