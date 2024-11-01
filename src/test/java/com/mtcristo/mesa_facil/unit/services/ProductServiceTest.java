package com.mtcristo.mesa_facil.unit.services;

import com.mtcristo.mesa_facil.models.Product;
import com.mtcristo.mesa_facil.repositories.ProductRepository;
import com.mtcristo.mesa_facil.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private final String productId=String.valueOf(UUID.randomUUID());
    private final Product product=new Product();



    @BeforeEach
    void setup(){
        product.setId(productId);
    }

    @Test
    @DisplayName("Should return product")
    void findProductById(){
     when(productRepository.findById(productId)).thenReturn(Optional.of(product));
     assertEquals(productId,productService.findProductById(productId).getId());
    }

}
