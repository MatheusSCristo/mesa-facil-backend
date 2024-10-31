package com.mtcristo.mesa_facil.services;

import com.mtcristo.mesa_facil.dtos.Order.OrderAddProductDto;
import com.mtcristo.mesa_facil.dtos.Order.OrderCreateDto;
import com.mtcristo.mesa_facil.dtos.Order.OrderUpdateDto;
import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderCreateDto;
import com.mtcristo.mesa_facil.exceptions.CustomExceptions.OrderNotFoundException;
import com.mtcristo.mesa_facil.exceptions.CustomExceptions.ProductNotFoundException;
import com.mtcristo.mesa_facil.exceptions.CustomExceptions.RestaurantNotFoundException;
import com.mtcristo.mesa_facil.models.*;
import com.mtcristo.mesa_facil.repositories.OrderRepository;
import com.mtcristo.mesa_facil.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.hibernate.dialect.identity.Oracle12cIdentityColumnSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final RestaurantService restaurantService;

    private final ProductService productService;

    public Order findOrderById(String id) {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public Order createOrder(OrderCreateDto orderCreateDto) {
        Restaurant restaurant = restaurantService.findRestaurantById(orderCreateDto.getRestaurantId());
        Order order = new Order(orderCreateDto, restaurant);
        OrderTicket orderTicket = new OrderTicket(orderCreateDto.getOrderTicket(), order);
        order.setOrderTicket(orderTicket);
        return orderRepository.save(order);
    }

    public Order updateOrder(String orderId, OrderUpdateDto orderUpdateDto) {
        Order order = findOrderById(orderId);
        Optional.ofNullable(orderUpdateDto.getRating()).ifPresent(order::setRating);
        Optional.ofNullable(orderUpdateDto.getTax()).ifPresent(order::setTax);
        Optional.ofNullable(orderUpdateDto.getStatus()).ifPresent(order::setStatus);
        Optional.ofNullable(orderUpdateDto.getTableNumber()).ifPresent(order::setTableNumber);
        Optional.ofNullable(orderUpdateDto.getSubTotal()).ifPresent(order::setSubTotal);
        return orderRepository.save(order);
    }

    public Order addProductToOrder(String orderId, OrderAddProductDto orderAddProductDto) {
        Order order = findOrderById(orderId);
        List<Product> products= productService.findAllProductsById(orderAddProductDto.getProducts().stream().map(ProductOrderCreateDto::getProductId).toList());
        Map<String, Product> productMap=products.stream().collect(Collectors.toMap(Product::getId,product->product));
        List<ProductOrder> productOrders=new ArrayList<>();
        for(ProductOrderCreateDto productOrderCreateDto:orderAddProductDto.getProducts()){
            Product product=productMap.get(productOrderCreateDto.getProductId());
            if(product == null ){
                throw new ProductNotFoundException();
            }

            ProductOrder productOrder=new ProductOrder(
                    product,
                    productOrderCreateDto.getDetails(),
                    productOrderCreateDto.getQuantity(),
                    order);

            productOrders.add(productOrder);
        }
        order.getProducts().addAll(productOrders);
        return orderRepository.save(order);
    }


}
