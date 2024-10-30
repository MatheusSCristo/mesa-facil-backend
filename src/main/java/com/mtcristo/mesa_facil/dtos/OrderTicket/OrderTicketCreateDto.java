package com.mtcristo.mesa_facil.dtos.OrderTicket;

import jakarta.validation.constraints.NotBlank;

public record OrderTicketCreateDto(@NotBlank String name) {
}
