package com.mtcristo.mesa_facil.dtos.ProductOrder;

import com.mtcristo.mesa_facil.dtos.Product.ProductResponseDto;
import com.mtcristo.mesa_facil.enums.ProductOrderStatus;
import com.mtcristo.mesa_facil.models.Order;
import com.mtcristo.mesa_facil.models.Product;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductOrderResponseDto {
    private String id;
    private ProductResponseDto product;
    private String details;
    private Integer quantity;
    private ProductOrderStatus status;
}
