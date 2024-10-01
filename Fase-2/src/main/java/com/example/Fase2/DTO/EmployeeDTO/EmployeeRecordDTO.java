package com.example.Fase2.DTO.EmployeeDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record EmployeeRecordDTO(
        Long id, @NotNull(message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números")
        @Size(min = 11, max = 11, message = "O CPF deve conter 11 números")
        String cpf,

        @NotNull(message = "Nome é obrigatório")
        String name,

        String position,

        @NotNull(message = "Salário é obrigatório")
        double salary,

        String shift

) {}
