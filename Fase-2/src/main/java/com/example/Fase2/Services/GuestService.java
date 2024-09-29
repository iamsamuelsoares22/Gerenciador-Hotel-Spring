package com.example.Fase2.Services;

import com.example.Fase2.DTO.AddressRecordDTO;
import com.example.Fase2.DTO.GuestRecordDTO;
import com.example.Fase2.Entities.Address;
import com.example.Fase2.Entities.Guest;
import com.example.Fase2.Repository.AddressRepository;
import com.example.Fase2.Repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        Optional<Guest> existingGuest = guestRepository.findByCpf(guestRecordDTO.cpf());

        if (existingGuest.isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado!");
        }
        else{
            Guest guest = new Guest();

            guest.setCpf(guestRecordDTO.cpf());
            guest.setName(guestRecordDTO.name());
            guest.setBirthDate(guestRecordDTO.birthDate());
            guest.setContactNumber(guestRecordDTO.contactNumber());


            Address address = new Address();

            address.setZipCode(guestRecordDTO.address().zipCode());
            address.setCountry(guestRecordDTO.address().country());
            address.setNeighborhood(guestRecordDTO.address().neighborhood());
            address.setStreet(guestRecordDTO.address().street());

            addressRepository.save(address);
            guest.setAddress(address);


            return guestRepository.save(guest);
        }
    }

    public List<GuestRecordDTO> getAllGuests() {
        return guestRepository.findAll().stream()
                .map(this::mapToGuestRecordDTO)
                .collect(Collectors.toList());
    }















    private GuestRecordDTO mapToGuestRecordDTO(Guest guest) {
        return new GuestRecordDTO(
                guest.getId(),
                guest.getName(),
                guest.getCpf(),
                guest.getBirthDate(),
                guest.getContactNumber(),
                mapToAddressRecordDTO(guest.getAddress())
        );
    }

    private AddressRecordDTO mapToAddressRecordDTO(Address address) {
        if (address == null) return null;
        return new AddressRecordDTO(
                address.getId(),
                address.getZipCode(),
                address.getCountry(),
                address.getNeighborhood(),
                address.getStreet()
        );
    }


}
