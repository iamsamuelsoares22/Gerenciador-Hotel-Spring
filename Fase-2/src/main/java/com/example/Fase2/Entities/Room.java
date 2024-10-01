package com.example.Fase2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isAvailable; // Disponibilidade do quarto
    private int roomNumber; // Número do quarto
    private String type; // Tipo do quarto
    private int capacity; // Capacidade de pessoas
    private double price; // Preço por noite
}

