package co.com.product.catalog.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class MetaDTO {

    private static final String DEPLOYMENT_VERSION = "0.0.1";

    @Data
    @Builder(toBuilder = true)
    public static class Meta {

        @JsonProperty("_version")
        private String version;

        @JsonProperty("_requestDate")
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime requestDate;

        @JsonProperty("_responseSize")
        private int responseSize;

        @JsonProperty("_requestClient")
        private String requestClient;

    }

    public static <T> Meta build(T data, ServerRequest request) {
        return Meta.builder()
                .version(DEPLOYMENT_VERSION)
                .requestDate(LocalDateTime.now())
                .responseSize(getDataSize(data))
                .requestClient(request.path())
                .build();
    }

    private static <T> int getDataSize(T data) {
        if (data instanceof List) {
            return ((List) data).size();
        }
        return 1;
    }

}
