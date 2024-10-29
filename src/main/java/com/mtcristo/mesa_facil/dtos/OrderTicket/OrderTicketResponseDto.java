package com.mtcristo.mesa_facil.dtos.OrderTicket;

import com.mtcristo.mesa_facil.models.OrderTicket;

public class OrderTicketResponseDto {
    private String id;
    private String name;

    public OrderTicketResponseDto(OrderTicket orderTicket){
        this.id=orderTicket.getId();
        this.name=orderTicket.getName();
    }
}
