package com.mtcristo.mesa_facil.repositories;

import com.mtcristo.mesa_facil.models.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTicketRepository extends JpaRepository<OrderTicket,String> {
}
