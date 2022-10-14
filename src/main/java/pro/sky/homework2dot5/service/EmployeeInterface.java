package pro.sky.homework2dot5.service;

import pro.sky.homework2dot5.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework2dot5.exceptions.EmployeeNotFoundException;

import java.util.Collection;

public interface EmployeeInterface {
    Employee addEmployee(String firstName, String lastName, int salary, int departmentNumber) throws EmployeeAlreadyAddedException;

    Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> findAll();

    void fill();
}
