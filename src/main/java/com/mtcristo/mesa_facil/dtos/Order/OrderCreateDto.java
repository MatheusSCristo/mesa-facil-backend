package com.mtcristo.mesa_facil.dtos.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mtcristo.mesa_facil.dtos.OrderTicket.OrderTicketCreateDto;
import com.mtcristo.mesa_facil.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderCreateDto {
    private OrderTicketCreateDto orderTicket;
    @JsonProperty("restaurant_id")
    private String restaurantId;
    private Integer tableNumber;
    private LocalDateTime date=LocalDateTime.now();
    private OrderStatus status=OrderStatus.PROGRESS;
}
