package com.mtcristo.mesa_facil.models;

import com.mtcristo.mesa_facil.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_tb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne
    private OrderTicket orderTicket;
    @ManyToOne
    private Restaurant restaurant;
    @OneToMany(mappedBy = "order")
    private List<ProductOrder> products=new ArrayList<>();
    private Double subTotal;
    private Double tax;
    private Integer tableNumber;
    private Integer rating;
    private LocalDateTime date;
    private OrderStatus status;
}
