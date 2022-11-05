package co.com.product.catalog.repository.product.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("product")
public class ProductData implements Persistable<Long> {
    @Id
    private Long id;

    @Column
    private String name;

    @Transient
    private boolean newProduct;

    @Override
    @Transient
    public boolean isNew() {
        return this.newProduct || this.id == null;
    }

    public ProductData setAsNew() {
        this.newProduct = true;
        return this;
    }
}
