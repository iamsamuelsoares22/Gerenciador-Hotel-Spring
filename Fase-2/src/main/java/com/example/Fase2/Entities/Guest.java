package com.example.Fase2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guest extends Person {

    @Column(nullable = true)
    private String contactNumber; // Número de contato

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Address address; // Endereço
}

