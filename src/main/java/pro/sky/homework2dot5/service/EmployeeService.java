package pro.sky.homework2dot5.service;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map <String, Employee> employees;

    public EmployeeService (List <Employee> employees) {
        this.employees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already added :(");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee deleteEmployee (String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
           return employees.remove(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    public Employee findEmployee (String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}