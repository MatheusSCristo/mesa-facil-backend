package com.mtcristo.mesa_facil.unit.services;

import com.mtcristo.mesa_facil.dtos.Order.OrderAddProductDto;
import com.mtcristo.mesa_facil.dtos.Order.OrderCreateDto;
import com.mtcristo.mesa_facil.dtos.OrderTicket.OrderTicketCreateDto;
import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderCreateDto;
import com.mtcristo.mesa_facil.enums.OrderStatus;
import com.mtcristo.mesa_facil.models.*;
import com.mtcristo.mesa_facil.repositories.OrderRepository;
import com.mtcristo.mesa_facil.services.OrderService;
import com.mtcristo.mesa_facil.services.ProductService;
import com.mtcristo.mesa_facil.services.RestaurantService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private RestaurantService restaurantService;
    @Mock
    private ProductService productService;

    @Mock
    private OrderRepository orderRepository;


    @Test
    @DisplayName("Should return Order")
    void findOrderByIdTest() {
        String orderId = String.valueOf(UUID.randomUUID());
        Order order = new Order();
        order.setId(orderId);
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        assertEquals(orderId, orderService.findOrderById(orderId).getId());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    @DisplayName("Should create and return Order")
    void createOrder() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(String.valueOf(UUID.randomUUID()));
        OrderCreateDto orderCreateDto = new OrderCreateDto(
                new OrderTicketCreateDto("Matheus"), restaurant.getId(), 1, LocalDateTime.now(), OrderStatus.PROGRESS);
        Order order = new Order();
        order.setOrderTicket(new OrderTicket(orderCreateDto.getOrderTicket(), order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(restaurantService.findRestaurantById(restaurant.getId())).thenReturn(restaurant);
        assertEquals("Matheus", orderService.createOrder(orderCreateDto).getOrderTicket().getName());
        verify(restaurantService, times(1)).findRestaurantById(restaurant.getId());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    @DisplayName("Should add product to order and return the order")
    void addProductToOrder() {
        String orderId = String.valueOf(UUID.randomUUID());
        Order order = new Order();
        order.setId(orderId);
        Product product1 = new Product();
        product1.setId("1");
        Product product2 = new Product();
        product2.setId("2");
        List<Product> productList = List.of(product1, product2);

        OrderAddProductDto orderAddProductDto = new OrderAddProductDto(
                List.of(new ProductOrderCreateDto("1", "Details 1", 2), new ProductOrderCreateDto("2", "Details 2", 1))
        );
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));
        when(productService.findAllProductsById(anyList())).thenReturn(productList);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order updatedOrder = orderService.addProductToOrder(orderId, orderAddProductDto);
        assertEquals(2, updatedOrder.getProducts().size());

        verify(orderRepository, times(1)).findById(orderId);
        verify(productService, times(1)).findAllProductsById(anyList());
        verify(orderRepository, times(1)).save(any(Order.class));


    }

}
