package com.mtcristo.mesa_facil.dtos.Restaurant;

import com.mtcristo.mesa_facil.dtos.Order.OrderResponseDto;
import com.mtcristo.mesa_facil.dtos.ProductsCategory.ProductsCategoryResponseDto;
import com.mtcristo.mesa_facil.models.ProductsCategory;
import com.mtcristo.mesa_facil.models.Restaurant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RestaurantResponseDto {
    private String id;
    private String name;
    private List<ProductsCategoryResponseDto> categories;
    private List<OrderResponseDto> orders=new ArrayList<>();
    private Integer tables;
    private String email;

    public RestaurantResponseDto(Restaurant restaurant){
        this.id=restaurant.getId();
        this.name=restaurant.getName();
        this.categories=restaurant.getCategories().stream().map(ProductsCategoryResponseDto::new).toList();
        this.orders=restaurant.getOrders().stream().map(OrderResponseDto::new).toList();
        this.tables=restaurant.getTables();
        this.email=restaurant.getEmail();
    }


}
