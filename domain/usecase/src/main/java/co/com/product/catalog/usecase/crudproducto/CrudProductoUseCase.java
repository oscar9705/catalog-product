package co.com.product.catalog.usecase.crudproducto;

import co.com.product.catalog.model.product.Product;
import co.com.product.catalog.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CrudProductoUseCase {

    private final ProductRepository productRepository;

    public void create(Product product) {
        productRepository.create(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
