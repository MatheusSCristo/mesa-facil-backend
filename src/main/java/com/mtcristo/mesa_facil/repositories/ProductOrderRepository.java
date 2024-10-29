package com.mtcristo.mesa_facil.repositories;

import com.mtcristo.mesa_facil.models.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository  extends JpaRepository<ProductOrder,String> {
}
