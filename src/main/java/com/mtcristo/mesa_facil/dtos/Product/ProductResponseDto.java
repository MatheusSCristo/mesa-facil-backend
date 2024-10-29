package com.mtcristo.mesa_facil.dtos.Product;

import com.mtcristo.mesa_facil.models.ProductOrder;
import com.mtcristo.mesa_facil.models.ProductsCategory;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductResponseDto {
    private String id;
    private String name;
    private Double price;
    private String description;
    private List<String> ingredients=new ArrayList<>();
    private List<String> extras=new ArrayList<>();
    private String image;
}
