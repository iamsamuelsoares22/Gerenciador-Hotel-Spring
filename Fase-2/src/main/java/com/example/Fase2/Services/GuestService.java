package com.example.Fase2.Services;

import com.example.Fase2.DTO.GuestRecordDTO;
import com.example.Fase2.Entities.Address;
import com.example.Fase2.Entities.Guest;
import com.example.Fase2.Repository.AddressRepository;
import com.example.Fase2.Repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository, AddressRepository addressRepository) {
        this.guestRepository = guestRepository;
        this.addressRepository = addressRepository;
    }

    public Guest saveGuest(GuestRecordDTO guestRecordDTO) {

        // Verifica se já existe um hóspede com o mesmo CPF
        Optional<Guest> existingGuest = guestRepository.findByCpf(guestRecordDTO.cpf());

        if (existingGuest.isPresent()) {
            throw new IllegalArgumentException("Já existe um hóspede com esse cpf: " + guestRecordDTO.cpf());
        }
        else{
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


            Address savedAddress = addressRepository.save(address);
            guest.setAddress(savedAddress);

            return guestRepository.save(guest);
        }
    }

}
