package com.mtcristo.mesa_facil.dtos.Order;

import com.mtcristo.mesa_facil.dtos.OrderTicket.OrderTicketResponseDto;
import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderResponseDto;
import com.mtcristo.mesa_facil.enums.OrderStatus;
import com.mtcristo.mesa_facil.models.OrderTicket;
import com.mtcristo.mesa_facil.models.ProductOrder;
import com.mtcristo.mesa_facil.models.Restaurant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderResponseDto {
    private String id;
    private OrderTicketResponseDto orderTicket;
    private List<ProductOrderResponseDto> products=new ArrayList<>();
    private Double subTotal;
    private Double tax;
    private Integer tableNumber;
    private Integer rating;
    private LocalDateTime date;
    private OrderStatus status;
}
