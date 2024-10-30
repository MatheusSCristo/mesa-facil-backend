package com.mtcristo.mesa_facil.services;

import com.mtcristo.mesa_facil.exceptions.CustomExceptions.ProductNotFoundException;
import com.mtcristo.mesa_facil.models.Product;
import com.mtcristo.mesa_facil.models.ProductOrder;
import com.mtcristo.mesa_facil.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById(String id){
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> findAllProductsById(List<String> ids){
        return productRepository.findAllById(ids);
    }

}
