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
public class Guest extends Person {


    @Column(nullable = true)
    private String contactNumber; // Número de contato


    @OneToOne
    @JoinColumn(name = "Address")
    private Address address; // Endereço

}
