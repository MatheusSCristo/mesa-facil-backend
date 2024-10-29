package com.mtcristo.mesa_facil.controllers;

import com.mtcristo.mesa_facil.dtos.Restaurant.RestaurantAddTableDto;
import com.mtcristo.mesa_facil.dtos.Restaurant.RestaurantCreateDto;
import com.mtcristo.mesa_facil.dtos.Restaurant.RestaurantResponseDto;
import com.mtcristo.mesa_facil.models.Restaurant;
import com.mtcristo.mesa_facil.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<RestaurantResponseDto> findRestaurantById(@RequestParam String id) {
        Restaurant restaurant = restaurantService.findRestaurantById(id);
        return ResponseEntity.ok().body(new RestaurantResponseDto(restaurant));
    }

    @PostMapping
    public ResponseEntity<RestaurantResponseDto> createRestaurant(@RequestBody RestaurantCreateDto restaurantCreateDto) {
        Restaurant restaurant = restaurantService.createRestaurant(restaurantCreateDto);
        return ResponseEntity.ok().body(new RestaurantResponseDto(restaurant));
    }

    @PutMapping
    public ResponseEntity<RestaurantResponseDto> addTableToRestaurant(@RequestParam String id,
                                                                      @RequestBody RestaurantAddTableDto restaurantAddTableDto) {
        Restaurant restaurant = restaurantService.addTableToRestaurant(id,restaurantAddTableDto);
        return ResponseEntity.ok().body(new RestaurantResponseDto(restaurant));
    }





}
