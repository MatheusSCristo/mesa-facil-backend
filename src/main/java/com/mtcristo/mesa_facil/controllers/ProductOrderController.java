package com.mtcristo.mesa_facil.controllers;

import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderResponseDto;
import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderUpdateStatusDto;
import com.mtcristo.mesa_facil.models.ProductOrder;
import com.mtcristo.mesa_facil.services.ProductOrderService;
import com.mtcristo.mesa_facil.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product_order")
@RequiredArgsConstructor
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    @PatchMapping
    public ResponseEntity<ProductOrderResponseDto> updateProductOrderStatus(@RequestParam String id, @RequestBody ProductOrderUpdateStatusDto productOrderUpdateStatusDto) {
        ProductOrder productOrder = productOrderService.updateProductOrderStatus(id, productOrderUpdateStatusDto);
        return ResponseEntity.ok().body(new ProductOrderResponseDto(productOrder));
    }


}
