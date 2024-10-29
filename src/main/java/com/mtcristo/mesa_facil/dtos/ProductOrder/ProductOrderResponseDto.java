package com.mtcristo.mesa_facil.dtos.ProductOrder;

import com.mtcristo.mesa_facil.dtos.Product.ProductResponseDto;
import com.mtcristo.mesa_facil.enums.ProductOrderStatus;
import com.mtcristo.mesa_facil.models.ProductOrder;
import lombok.Data;

@Data
public class ProductOrderResponseDto {
    private String id;
    private ProductResponseDto product;
    private String details;
    private Integer quantity;
    private ProductOrderStatus status;

    public ProductOrderResponseDto(ProductOrder productOrder){
        this.id=productOrder.getId();
        this.product=new ProductResponseDto(productOrder.getProduct());
        this.details=productOrder.getDetails();
        this.quantity=productOrder.getQuantity();
        this.status=productOrder.getStatus();
    }
}
