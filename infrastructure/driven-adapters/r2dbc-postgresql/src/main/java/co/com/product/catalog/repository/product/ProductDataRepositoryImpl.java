package co.com.product.catalog.repository.product;

import co.com.product.catalog.config.AdapterOperations;
import co.com.product.catalog.model.product.Product;
import co.com.product.catalog.model.product.gateways.ProductRepository;
import co.com.product.catalog.repository.product.data.ProductData;
import co.com.product.catalog.repository.product.data.ProductMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductDataRepositoryImpl
    extends AdapterOperations<Product, ProductData,
        Long, IProductRepository>
        implements ProductRepository {

    public ProductDataRepositoryImpl(IProductRepository repository,
                                     ProductMapper mapper) {
        super(repository, mapper::toData, mapper::toEntity);
    }
    @Override
    public Mono<Product> create(Product product) {

        return doQuery(repository.save(convertToData(product).setAsNew()));
    }

    @Override
    public Flux<Product> findAll() {
        return doQueryMany(repository.findAll());
    }
}
