package pro.sky.homework2dot5.service;
import org.springframework.stereotype.Service;
import pro.sky.homework2dot5.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework2dot5.exceptions.EmployeeNotFoundException;
import pro.sky.homework2dot5.exceptions.InvalidInputException;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService implements EmployeeInterface {
    private final Map <String, Employee> employees;

    public EmployeeService () {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentNumber) throws EmployeeAlreadyAddedException {
        validationOfInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, departmentNumber);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already added :(");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        validationOfInput(firstName, lastName);
        String key = capitalize(firstName.toLowerCase()) + " " + capitalize(lastName.toLowerCase());
        if (employees.containsKey(key)) {
           return employees.remove(key);
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        validationOfInput(firstName, lastName);
        String key = capitalize(firstName.toLowerCase()) + " " + capitalize(lastName.toLowerCase());
        if (employees.containsKey(key)) {
            return employees.get(key);
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validationOfInput(String firstName, String lastName) {
        if (!isAlpha(firstName) || !isAlpha(lastName)) {
            throw new InvalidInputException();
        }
    }
}