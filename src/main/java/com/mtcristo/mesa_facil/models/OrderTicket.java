package com.mtcristo.mesa_facil.models;

import com.mtcristo.mesa_facil.dtos.OrderTicket.OrderTicketCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @OneToOne
    private Order order;

    public OrderTicket(OrderTicketCreateDto orderTicket,Order order) {
        this.name=orderTicket.name();
        this.order=order;
    }


}
