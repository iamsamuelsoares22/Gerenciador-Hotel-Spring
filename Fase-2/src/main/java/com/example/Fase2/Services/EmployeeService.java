package com.example.Fase2.Services;

import com.example.Fase2.Entities.Employee;
import com.example.Fase2.Repository.EmployeeRepository;
import com.example.Fase2.VerifcData.FormatVerifcData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE - UPDATE
    public void createEmployee() {

        String name = null, cpf = null, birthDate = null;
        String position = null, shift = null;
        double salary = 0.0;

        // ------------------------------------------------- Dados Pessoais -------------------------------------------------//
        Employee employee = new Employee();
        FormatVerifcData verifcData = new FormatVerifcData();

        name = JOptionPane.showInputDialog(null, "Nome: ");
        //employee.setName(name);

        while (true) {
            cpf = JOptionPane.showInputDialog(null, "CPF: ");

            if (verifcData.verificCPF(cpf)) {
                long count = employeeRepository.countByCpf(cpf);

                if (count == 0) {
                    //employee.setCpf(verifcData.formartCPF(cpf));
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Já existe um funcionário com esse CPF!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido, tente novamente!");
            }
        }

        while (true) {
            birthDate = JOptionPane.showInputDialog(null, "Data de nascimento no formato ddMMyyyy: ");

            if (verifcData.verifcDate(birthDate)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                LocalDate birthDateNew = LocalDate.parse(birthDate, formatter);
                //employee.setBirthDate(birthDateNew);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Data inválida, tente novamente!");
                JOptionPane.showMessageDialog(null, "verifique se sua data está no formato ddMMyyyy!");
            }
        }

        // ------------------------------------------------- Informações do Empregado -------------------------------------------------//
        position = JOptionPane.showInputDialog(null, "Cargo: ");
        employee.setPosition(position);

        salary = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário: "));
        employee.setSalary(salary);

        shift = JOptionPane.showInputDialog(null, "Turno de trabalho: ");
        employee.setShift(shift);

        employeeRepository.save(employee);
        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
    }

    


}
