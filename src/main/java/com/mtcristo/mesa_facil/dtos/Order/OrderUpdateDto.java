package com.mtcristo.mesa_facil.dtos.Order;

import com.mtcristo.mesa_facil.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderUpdateDto {
    private Double subTotal;
    private Double tax;
    private Integer tableNumber;
    private Integer rating;
    private OrderStatus status;
}
