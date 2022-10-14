package pro.sky.homework2dot5.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2dot5.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework2dot5.exceptions.EmployeeNotFoundException;
import pro.sky.homework2dot5.service.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeInterface employeeService;

    public EmployeeController(EmployeeInterface employeeService) {
        this.employeeService = employeeService;
        employeeService.fill();
    }

    @GetMapping ("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departmentNumber) throws EmployeeAlreadyAddedException {
        return employeeService.addEmployee(firstName, lastName, salary, departmentNumber);
    }

    @GetMapping ("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping ("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeNotFoundException {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping ("/list")
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/add-all")
    public void addAll () {
        employeeService.fill();
    }
}
