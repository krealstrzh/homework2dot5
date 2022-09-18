package pro.sky.homework2dot5.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2dot5.service.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping ("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) throws EmployeeAlreadyAddedException {
        return employeeService.addEmployee(firstName, lastName);
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
}
