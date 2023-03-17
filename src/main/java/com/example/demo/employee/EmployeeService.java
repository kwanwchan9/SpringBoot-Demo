package com.example.demo.employee;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;


    // Create
    Employee saveEmployee(Employee employee) {
        employee.setName(employee.getName().toUpperCase());
        return employeeRepository.save(employee);
    }

    // Read
    List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    Employee getEmployee(Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException(
                            "employee with id " + id + " not found");
                    log.error("error in getting employee {}", id, notFoundException);
                    return notFoundException;
                });
    }

    Employee findEmployeeByName(String name) {
        return employeeRepository
                .findEmployeeByName(name)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException(
                            "employee with name " + name + " not found");
                    log.error("error in getting employee {}", name, notFoundException);
                    return notFoundException;
                });
    }

    // Update
    List<Employee> updateEmployee(Employee employee) {
        return employeeRepository.saveAllAndFlush(List.of(employee));
    }

    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
