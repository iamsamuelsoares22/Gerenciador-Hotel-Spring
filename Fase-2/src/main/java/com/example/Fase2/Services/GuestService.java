package com.example.Fase2.Services;

import com.example.Fase2.DTO.GuestRecordDTO;
import com.example.Fase2.Entities.Address;
import com.example.Fase2.Entities.Guest;
import com.example.Fase2.Repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }


   public Guest saveGuest(GuestRecordDTO guestRecordDTO){

        Guest guest = new Guest();
        Address address = new Address();

        guest.setCpf(guestRecordDTO.cpf());
        guest.setName(guestRecordDTO.name());
        guest.setBirthDate(guestRecordDTO.birthDate());
        guest.setContactNumber(guestRecordDTO.contactNumber());


        address.setZipCode(guestRecordDTO.address().zipCode());
        address.setCountry(guestRecordDTO.address().country());
        address.setNeighborhood(guestRecordDTO.address().neighborhood());
        address.setStreet(guestRecordDTO.address().street());

        guest.setAddress(address);

        return guestRepository.save(guest);
   }
}
