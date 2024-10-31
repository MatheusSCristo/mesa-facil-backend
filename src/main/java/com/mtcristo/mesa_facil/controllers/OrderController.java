package com.mtcristo.mesa_facil.controllers;

import com.mtcristo.mesa_facil.dtos.Order.OrderAddProductDto;
import com.mtcristo.mesa_facil.dtos.Order.OrderCreateDto;
import com.mtcristo.mesa_facil.dtos.Order.OrderResponseDto;
import com.mtcristo.mesa_facil.dtos.Order.OrderUpdateDto;
import com.mtcristo.mesa_facil.models.Order;
import com.mtcristo.mesa_facil.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<OrderResponseDto> findOrderById(@RequestParam String id){
        Order order=orderService.findOrderById(id);
        return ResponseEntity.ok().body(new OrderResponseDto(order));
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderCreateDto orderCreateDto){
        Order order=orderService.createOrder(orderCreateDto);
        return ResponseEntity.ok().body(new OrderResponseDto(order));
    }

    @PatchMapping
    public ResponseEntity<OrderResponseDto> updateOrder(@RequestParam String id,@RequestBody OrderUpdateDto orderUpdateDto){
        Order order=orderService.updateOrder(id,orderUpdateDto);
        return ResponseEntity.ok().body(new OrderResponseDto(order));
    }

    @PatchMapping("/add")
    public ResponseEntity<OrderResponseDto> addProductToOrder(@RequestParam String id,@RequestBody OrderAddProductDto orderAddProductDto){
        Order order=orderService.addProductToOrder(id,orderAddProductDto);
        return ResponseEntity.ok().body(new OrderResponseDto(order));
    }



}
