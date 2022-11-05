package co.com.product.catalog.api.dto;

import co.com.product.catalog.model.product.Product;
import co.com.product.catalog.model.product.error.Error;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.ServerRequest;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
public class ResponseDTO {

    @Autowired
    private MetaDTO.Meta meta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Error error;

    public static ResponseDTO success(Object data, ServerRequest request){
        return ResponseDTO.builder()
                .meta(MetaDTO.build(data, request))
                .data(data)
                .build();
    }

    public static ResponseDTO failed(Error error, ServerRequest request){
        return ResponseDTO.builder()
                .meta(MetaDTO.build(error, request))
                .error(error)
                .build();
    }

}

