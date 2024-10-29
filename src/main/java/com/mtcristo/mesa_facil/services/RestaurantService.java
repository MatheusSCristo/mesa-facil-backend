package com.mtcristo.mesa_facil.services;

import com.mtcristo.mesa_facil.dtos.Restaurant.RestaurantAddTableDto;
import com.mtcristo.mesa_facil.dtos.Restaurant.RestaurantCreateDto;
import com.mtcristo.mesa_facil.exceptions.CustomExceptions.RestaurantNotFoundException;
import com.mtcristo.mesa_facil.models.Restaurant;
import com.mtcristo.mesa_facil.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant findRestaurantById(String id){
        return restaurantRepository.findById(id).orElseThrow(RestaurantNotFoundException::new);
    }

    public Restaurant createRestaurant(RestaurantCreateDto restaurantCreateDto){
        Restaurant restaurant=new Restaurant(restaurantCreateDto);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant addTableToRestaurant(String restaurantId,RestaurantAddTableDto restaurantAddTableDto){
        Restaurant restaurant=findRestaurantById(restaurantId);
        restaurant.setTables(restaurantAddTableDto.tables());
        return restaurantRepository.save(restaurant);
    }

}
