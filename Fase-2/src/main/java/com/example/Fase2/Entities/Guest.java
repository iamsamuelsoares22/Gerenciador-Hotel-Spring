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
    @MapsId // Esta anotação vincula o ID do Guest ao ID do Address
    @JoinColumn(name = "id") // A coluna 'id' será usada como chave estrangeira
    private Address address; // Endereço
}

