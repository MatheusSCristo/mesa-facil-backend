package com.mtcristo.mesa_facil.repositories;

import com.mtcristo.mesa_facil.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository  extends JpaRepository<Restaurant,String> {
}
