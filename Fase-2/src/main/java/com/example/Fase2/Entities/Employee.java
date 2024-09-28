package com.example.Fase2.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
public class Employee extends Person {

    @Column(nullable = true)
    private String position; // Cargo

    @Column(nullable = true)
    private double salary; // Salário

    @Column(nullable = true)
    private String shift; // Turno de trabalho
}
