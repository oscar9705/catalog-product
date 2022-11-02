package co.com.product.catalog.model.product.gateways;

import co.com.product.catalog.model.product.Product;

import java.util.List;

public interface ProductRepository {
    void create(Product product);
    List<Product> findAll();
}
