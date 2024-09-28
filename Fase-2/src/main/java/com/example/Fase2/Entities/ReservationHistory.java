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
public class ReservationHistory {

    @Id
    private Long reservationId; // ID da reserva

    @Column(nullable = true)
    private String status; // Status da reserva

    @Column(nullable = true)
    private LocalDate changeDate; // Data da mudança de status
}
