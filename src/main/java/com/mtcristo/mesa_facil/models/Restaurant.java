package com.mtcristo.mesa_facil.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @OneToMany(mappedBy = "restaurant")
    private List<ProductsCategory> categories;
    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders=new ArrayList<>();
    private Integer tables;
    private String email;
    private String password;

}
