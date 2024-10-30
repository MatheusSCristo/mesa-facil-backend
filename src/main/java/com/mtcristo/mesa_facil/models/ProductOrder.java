package com.mtcristo.mesa_facil.models;

import com.mtcristo.mesa_facil.enums.ProductOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private Product product;
    @Column(columnDefinition = "TEXT")
    private String details;
    private Integer quantity;
    private ProductOrderStatus status = ProductOrderStatus.PROCESSING;
    @ManyToOne
    private Order order;

    public ProductOrder(Product product,String details, Integer quantity,Order order){
        this.product=product;
        this.details=details;
        this.quantity=quantity;
        this.order=order;
    }


}
