package com.example.Fase2.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Address address; // Endereço
}

