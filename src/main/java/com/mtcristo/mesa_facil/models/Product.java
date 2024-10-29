package com.mtcristo.mesa_facil.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ElementCollection
    private List<String> ingredients=new ArrayList<>();
    @ElementCollection
    private List<String> extras=new ArrayList<>();
    private String image;
    @ManyToOne
    private ProductsCategory productsCategory;
    @OneToMany
    private List<ProductOrder> productOrder= new ArrayList<>();
}
