package com.mtcristo.mesa_facil.models;

import com.mtcristo.mesa_facil.models.enums.OrderStatus;
import com.mtcristo.mesa_facil.models.enums.ProductOrderStatus;
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
    private String observations;
    private Integer quantity;
    private ProductOrderStatus status = ProductOrderStatus.PROCESSING;
    @ManyToOne
    private Order order;

}
