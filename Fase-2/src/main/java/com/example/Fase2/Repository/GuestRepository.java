package com.example.Fase2.Repository;

import com.example.Fase2.Entities.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    //Verifica se existe um cpf cadastrado
    Optional<Guest> findByCpf(String cpf);
}