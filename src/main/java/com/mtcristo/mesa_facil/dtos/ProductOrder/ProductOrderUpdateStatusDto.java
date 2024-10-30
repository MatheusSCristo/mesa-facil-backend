package com.mtcristo.mesa_facil.dtos.ProductOrder;

import com.mtcristo.mesa_facil.enums.ProductOrderStatus;
import jakarta.validation.constraints.NotBlank;

public record ProductOrderUpdateStatusDto(@NotBlank ProductOrderStatus status) {
}
