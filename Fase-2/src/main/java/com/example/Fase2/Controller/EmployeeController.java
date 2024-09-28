package com.example.Fase2.Controller;

import com.example.Fase2.Entities.Employee;
import com.example.Fase2.Entities.Guest;
import com.example.Fase2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/create")
    public String createGuest(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Guest successfully created!";
    }

    /*
    @GetMapping("/list")
    public List<Guest> listAllGuests() {
        return employeeRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGuestById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Guest successfully deleted!";
    }

     */
}
