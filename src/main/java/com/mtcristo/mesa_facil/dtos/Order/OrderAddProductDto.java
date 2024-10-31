package com.mtcristo.mesa_facil.dtos.Order;

import com.mtcristo.mesa_facil.dtos.ProductOrder.ProductOrderCreateDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderAddProductDto {

    private List<ProductOrderCreateDto> products;


}
