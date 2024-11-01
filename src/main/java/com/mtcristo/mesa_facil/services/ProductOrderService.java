package com.mtcristo.mesa_facil.services;

import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderUpdateStatusDto;
import com.mtcristo.mesa_facil.exceptions.CustomExceptions.ProductOrderNotFoundException;
import com.mtcristo.mesa_facil.models.ProductOrder;
import com.mtcristo.mesa_facil.repositories.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  ProductOrderService {

    private final ProductOrderRepository productOrderRepository;

    public ProductOrder findProductOrderById(String id){
        return productOrderRepository.findById(id).orElseThrow(ProductOrderNotFoundException::new);
    }


    public ProductOrder updateProductOrderStatus(String id, ProductOrderUpdateStatusDto productOrderUpdateStatusDto){
        ProductOrder productOrder=findProductOrderById(id);
        productOrder.setStatus(productOrderUpdateStatusDto.status());
        return productOrderRepository.save(productOrder);
    }

}
