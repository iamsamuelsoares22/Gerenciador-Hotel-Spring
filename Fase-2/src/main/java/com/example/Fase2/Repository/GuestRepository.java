package com.example.Fase2.Repository;

import com.example.Fase2.Entities.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    //Lista por CPF
    Optional<Guest> findByCpf(String cpf);

    //Deletar por CPF
    void delete(Guest guest);
}