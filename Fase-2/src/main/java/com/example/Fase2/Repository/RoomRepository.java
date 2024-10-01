package com.example.Fase2.Repository;

import com.example.Fase2.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIsAvailable(String isAvailable);

    Optional<Room> findByRoomNumber(int roomNumber); // Para encontrar por número do quarto

}
