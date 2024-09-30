package com.example.Fase2.Services;

import com.example.Fase2.DTO.EmployeeDTO.EmployeeRecordDTO;
import com.example.Fase2.Entities.Employee;
import com.example.Fase2.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    public Employee saveEmployee(EmployeeRecordDTO employeeRecordDTO){

        Optional<Employee> existingEmployee = employeeRepository.findByCpf(employeeRecordDTO.cpf());

        if (existingEmployee.isPresent()){
            throw new IllegalArgumentException("CPF cadastrado!");
        }
        else{
            Employee employee = new Employee();

            employee.setCpf(employeeRecordDTO.cpf());
            employee.setName(employeeRecordDTO.name());
            employee.setPosition(employeeRecordDTO.shift());
            employee.setSalary(employeeRecordDTO.salary());
            employee.setShift(employeeRecordDTO.shift());

            return employeeRepository.save(employee);
        }
    }




}
