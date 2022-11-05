package co.com.product.catalog.repository.product.data;

import co.com.product.catalog.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    Product toEntity(ProductData product);
    ProductData toData(Product product);
}
