package com.example.Fase2.Services;

import com.example.Fase2.DTO.RoomDTO.RoomRecordDTO;
import com.example.Fase2.Entities.Room;
import com.example.Fase2.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(RoomRecordDTO roomRecordDTO) {

        Optional<Room> existingRoom = roomRepository.findByRoomNumber(roomRecordDTO.roomNumber());

        if (existingRoom.isPresent()) {
            throw new IllegalArgumentException("Quarto com este número já existe.");
        }
        else{
            Room room = new Room();
            room.setRoomNumber(roomRecordDTO.roomNumber());
            room.setType(roomRecordDTO.type());
            room.setCapacity(roomRecordDTO.capacity());
            room.setPrice(roomRecordDTO.price());

            room.setIsAvailable("disponível");

            return roomRepository.save(room);
        }
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByIsAvailable("disponível");
    }

    public Room updateRoomStatus(int roomNumber, String isAvailable) {
        Room room = roomRepository.findByRoomNumber(roomNumber).orElseThrow(() -> new NoSuchElementException("Não existe nenhum quarto com esse número: " + roomNumber));
        room.setIsAvailable(isAvailable);
        return roomRepository.save(room);
    }
}

