package com.example.Fase2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String cpf; // CPF do hóspede

    @Column(nullable = true)
    private int roomNumber; // Número do quarto

    @Column(nullable = true)
    private LocalDate checkInDate; // Data de entrada

    @Column(nullable = true)
    private LocalDate checkOutDate; // Data de saída

    @Column(nullable = true)
    private int numberOfPeople; // Quantidade de pessoas
}
