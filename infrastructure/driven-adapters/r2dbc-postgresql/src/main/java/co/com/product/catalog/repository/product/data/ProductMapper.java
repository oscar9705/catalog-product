package co.com.product.catalog.repository.product.data;

import co.com.product.catalog.model.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductData product);
    ProductData toData(Product product);
}
