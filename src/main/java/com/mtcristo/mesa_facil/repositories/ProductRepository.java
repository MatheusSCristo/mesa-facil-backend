package com.mtcristo.mesa_facil.repositories;

import com.mtcristo.mesa_facil.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,String> {
}
