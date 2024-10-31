package com.mtcristo.mesa_facil.dtos.ProductOrder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductOrderCreateDto {

    @JsonProperty("product_id")
    private String productId;
    private String details;
    private Integer quantity;

}
