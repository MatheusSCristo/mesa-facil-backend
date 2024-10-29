package com.mtcristo.mesa_facil.exceptions.CustomExceptions;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(){
        super("Restaurant was not found");
    }
}
