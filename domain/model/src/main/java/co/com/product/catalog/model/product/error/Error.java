package co.com.product.catalog.model.product.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Error implements Serializable {

    private String id;
    private String type;
    private String reason;
    private String title;
    private String detail;
    private String source;
}
