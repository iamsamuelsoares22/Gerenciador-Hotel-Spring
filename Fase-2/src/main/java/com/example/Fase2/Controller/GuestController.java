package com.example.Fase2.Controller;

import com.example.Fase2.DTO.GuestRecordDTO;
import com.example.Fase2.Entities.Guest;
import com.example.Fase2.Services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guests")
public class GuestController {


    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService){
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<Guest> saveGuest(@RequestBody GuestRecordDTO guestRecordDTO) {
        Guest guest = guestService.saveGuest(guestRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(guest);
    }


    /*

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        //List<Guest> guests = guestService.;
        return ResponseEntity.ok(guests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        //Guest guest = guestService.findGuestById(id);
        if (guest != null) {
            return ResponseEntity.ok(guest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuestById(id);
        return ResponseEntity.noContent().build();
    }

     */
}
