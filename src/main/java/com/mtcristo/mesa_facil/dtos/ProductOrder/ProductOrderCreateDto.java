package com.mtcristo.mesa_facil.dtos.ProductOrder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductOrderCreateDto {

    @JsonProperty("product_id")
    private String productId;
    private String details;
    private Integer quantity;

}
