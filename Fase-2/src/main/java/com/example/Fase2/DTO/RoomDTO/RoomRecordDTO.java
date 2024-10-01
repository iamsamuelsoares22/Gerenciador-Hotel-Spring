package com.example.Fase2.DTO.RoomDTO;

import jakarta.validation.constraints.NotNull;

public record RoomRecordDTO(
        @NotNull(message = "O número do quarto é obrigatório")
        Integer roomNumber,

        String type,
        int capacity,
        double price
) {}

