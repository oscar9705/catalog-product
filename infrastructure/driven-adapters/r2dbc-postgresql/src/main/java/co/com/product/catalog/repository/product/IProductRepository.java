package co.com.product.catalog.repository.product;

import co.com.product.catalog.repository.product.data.ProductData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IProductRepository extends ReactiveCrudRepository<ProductData, Long> {
}
