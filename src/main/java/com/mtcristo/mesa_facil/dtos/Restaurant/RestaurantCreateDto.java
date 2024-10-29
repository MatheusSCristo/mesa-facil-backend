package com.mtcristo.mesa_facil.dtos.Restaurant;

import lombok.Data;

@Data
public class RestaurantCreateDto {
    private String name;
    private String email;
    private String password;

}
