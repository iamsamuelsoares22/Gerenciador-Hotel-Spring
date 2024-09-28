package com.example.Fase2.Repository;

import com.example.Fase2.Entities.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GuestRepository extends JpaRepository<Guest, Long> {

}