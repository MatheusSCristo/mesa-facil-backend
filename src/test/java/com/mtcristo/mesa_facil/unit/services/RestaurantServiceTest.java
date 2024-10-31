package com.mtcristo.mesa_facil.unit.services;

import com.mtcristo.mesa_facil.dtos.Restaurant.RestaurantAddTableDto;
import com.mtcristo.mesa_facil.dtos.Restaurant.RestaurantCreateDto;
import com.mtcristo.mesa_facil.models.Restaurant;
import com.mtcristo.mesa_facil.repositories.RestaurantRepository;
import com.mtcristo.mesa_facil.services.RestaurantService;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    private final Restaurant restaurant = new Restaurant();

    private final String restaurantId = String.valueOf(UUID.randomUUID());

    @BeforeEach
    void setup(){
        restaurant.setId(restaurantId);
    }



    @Test
    @DisplayName("Should find Restaurant by id and return it")
    void findRestaurantById() {
        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(restaurant));
        assertEquals(restaurant.getId(), restaurantService.findRestaurantById(restaurantId).getId());
    }

    @Test
    @DisplayName("Should create restaurant and return it")
    void createRestaurant() {
        RestaurantCreateDto restaurantCreateDto=new RestaurantCreateDto("Matheus","matheus@gmail.com","123456");
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(new Restaurant(restaurantCreateDto));
        assertEquals(restaurantCreateDto.getName(),restaurantService.createRestaurant(restaurantCreateDto).getName());
    }

    @Test
    @DisplayName("Shoul add table to restaurant and return it")
    void addTableToRestaurant(){
        RestaurantAddTableDto restaurantAddTableDto=new RestaurantAddTableDto(3);
        restaurant.setTables(restaurantAddTableDto.tables());
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);
        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(restaurant));
        assertEquals(restaurant.getTables(),restaurantService.addTableToRestaurant(restaurantId,restaurantAddTableDto).getTables());


    }


}
