package com.mtcristo.mesa_facil.dtos.ProductsCategory;

import com.mtcristo.mesa_facil.models.Product;
import com.mtcristo.mesa_facil.models.Restaurant;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductsCategoryResponseDto {
    private String id;
    private String name;
    private List<Product> products=new ArrayList<>();
    private Restaurant restaurant;
}
