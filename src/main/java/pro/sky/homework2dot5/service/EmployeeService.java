package pro.sky.homework2dot5.service;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employeeBook;

    public EmployeeService (List <Employee> employeeBook) {
        this.employeeBook = new ArrayList<>();
    }

    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(lastName, firstName);
        if (employeeBook.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee already added :(");
        }
        return employee;
    }

    public Employee findEmployee (String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        if (employeeBook.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    public Employee deleteEmployee (String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        if (employeeBook.contains(employee)) {
            employeeBook.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeBook);
    }
}