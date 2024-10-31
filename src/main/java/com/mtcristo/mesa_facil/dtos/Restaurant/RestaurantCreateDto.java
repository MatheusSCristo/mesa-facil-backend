package com.mtcristo.mesa_facil.dtos.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantCreateDto {
    private String name;
    private String email;
    private String password;

}
