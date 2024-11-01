package com.mtcristo.mesa_facil.unit.services;

import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderUpdateStatusDto;
import com.mtcristo.mesa_facil.enums.ProductOrderStatus;
import com.mtcristo.mesa_facil.models.ProductOrder;
import com.mtcristo.mesa_facil.repositories.ProductOrderRepository;
import com.mtcristo.mesa_facil.services.ProductOrderService;
import org.junit.jupiter.api.Assertions;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductOrderServiceTest {

    @InjectMocks
    private ProductOrderService productOrderService;

    @Mock
    private ProductOrderRepository productOrderRepository;

    private final ProductOrder productOrder=new ProductOrder();
    private final String productOrderId=String.valueOf(UUID.randomUUID());

    @BeforeEach
    void setup(){
        productOrder.setId(productOrderId);
    }

    @Test
    @DisplayName("Should return ProductOrder")
    void findProductOrderById(){
        when(productOrderRepository.findById(productOrderId)).thenReturn(Optional.of(productOrder));
        assertEquals(productOrderId,productOrderService.findProductOrderById(productOrderId).getId());
        verify(productOrderRepository,times(1)).findById(productOrderId);
    }

    @Test
    @DisplayName("Should update status on ProductOrder")
    void updateProductOrderStatus(){
        ProductOrderUpdateStatusDto productOrderUpdateStatusDto=new ProductOrderUpdateStatusDto(ProductOrderStatus.DELIVERED);
        productOrder.setStatus(ProductOrderStatus.DELIVERED);
        when(productOrderRepository.findById(productOrderId)).thenReturn(Optional.of(productOrder));
        when(productOrderRepository.save(any(ProductOrder.class))).thenReturn(productOrder);
        assertEquals(productOrderId,productOrderService.updateProductOrderStatus(productOrderId,productOrderUpdateStatusDto).getId());
        verify(productOrderRepository,times(1)).findById(productOrderId);
        verify(productOrderRepository,times(1)).save(any(ProductOrder.class));

    }





}
