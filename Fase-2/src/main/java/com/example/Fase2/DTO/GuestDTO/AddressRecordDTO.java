package com.example.Fase2.DTO.GuestDTO;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressRecordDTO(

        Long id, @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números")
        @Size(min = 6, message = "O zip code deve conter mais de 5 números")
        String zipCode,

        String country,

        String neighborhood,

        String street
) {}
