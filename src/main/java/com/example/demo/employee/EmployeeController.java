package com.example.demo.employee;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/employee")
@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    @PostMapping()
    Employee createNewEmployee(@Validated @RequestBody Employee employee) {
        employee.setGender(Gender.valueOf(String.valueOf(employee.getGender()).toUpperCase()));
        return employeeService.saveEmployee(employee);
    }

    @GetMapping()
    List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "{employeeId}")
    Employee getEmployee(@PathVariable("employeeId") Long id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping()
    List<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    void deleteEmployee(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
    }

}
