package com.example.Fase2.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @OneToOne(mappedBy =  "address")
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
