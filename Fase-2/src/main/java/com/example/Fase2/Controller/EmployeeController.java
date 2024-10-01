package com.example.Fase2.Controller;

import com.example.Fase2.DTO.EmployeeDTO.EmployeeRecordDTO;
import com.example.Fase2.Entities.Employee;

import com.example.Fase2.Services.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeRecordDTO employeeRecordDTO) {
        Employee employee = employeeService.saveEmployee(employeeRecordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping
    public  ResponseEntity<List<Object>> getAllEmployee(){
        List<Object> employees = Collections.singletonList(employeeService.getAllEmployee());
        return ResponseEntity.ok(employees);
    }

}
