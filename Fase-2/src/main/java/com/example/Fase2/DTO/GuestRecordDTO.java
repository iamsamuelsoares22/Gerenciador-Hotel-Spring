package com.example.Fase2.DTO;

import java.time.LocalDate;

public record GuestRecordDTO(String cpf, String name, LocalDate birthDate, String contactNumber, AddreesRecordDTO address) {
}
