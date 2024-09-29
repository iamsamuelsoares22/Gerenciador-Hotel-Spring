package com.example.Fase2.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Guest guest;

    @Column(nullable = true)
    private String zipCode; // CEP

    @Column(nullable = true)
    private String country; // País

    @Column(nullable = true)
    private String neighborhood; // Bairro

    @Column(nullable = true)
    private String street; // Rua
}


