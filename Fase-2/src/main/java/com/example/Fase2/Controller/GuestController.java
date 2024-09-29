package com.example.Fase2.Controller;

import com.example.Fase2.DTO.GuestRecordDTO;
import com.example.Fase2.Entities.Guest;
import com.example.Fase2.Services.GuestService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/guests")
@Validated
public class GuestController {


    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService){
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<Guest> saveGuest(@Valid @RequestBody GuestRecordDTO guestRecordDTO) {
        Guest guest = guestService.saveGuest(guestRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(guest);
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAllGuets(){
        List<Object> guests = Collections.singletonList(guestService.getAllGuests());
        return ResponseEntity.ok(guests);
    }





    // Manipulador de exceções
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // Manipulador de exceções para validação de CPF e outros campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
