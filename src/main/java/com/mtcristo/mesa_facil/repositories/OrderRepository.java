package com.mtcristo.mesa_facil.repositories;

import com.mtcristo.mesa_facil.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
