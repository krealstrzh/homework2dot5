package pro.sky.homework2dot5.service;

import java.util.Collection;

public interface EmployeeInterface {
    Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException;

    Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> findAll();

    void addAll();
}
