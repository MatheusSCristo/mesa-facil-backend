package com.mtcristo.mesa_facil.dtos.ProductsCategory;

import com.mtcristo.mesa_facil.dtos.Product.ProductResponseDto;
import com.mtcristo.mesa_facil.models.Product;
import com.mtcristo.mesa_facil.models.ProductsCategory;
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
    private List<ProductResponseDto> products=new ArrayList<>();

    public ProductsCategoryResponseDto(ProductsCategory productsCategory){
        this.id=productsCategory.getId();
        this.name=productsCategory.getName();
        this.products=productsCategory.getProducts().stream().map(ProductResponseDto::new).toList();
    }

}
