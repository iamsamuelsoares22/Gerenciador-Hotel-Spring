package com.example.Fase2.Repository;

import com.example.Fase2.Entities.Employee;

import com.example.Fase2.Entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Lista por CPF
    Optional<Employee> findByCpf(String cpf);

    //Deletar por CPF
    void delete(Employee employee);
}