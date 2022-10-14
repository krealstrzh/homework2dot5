package pro.sky.homework2dot5.service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework2dot5.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework2dot5.exceptions.EmployeeNotFoundException;
import pro.sky.homework2dot5.exceptions.InvalidInputException;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService implements EmployeeInterface {
    private final Map <String, Employee> employees;

    public EmployeeService (List <Employee> employees) {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int departmentNumber) throws EmployeeAlreadyAddedException {
        validationOfInput(firstName, lastName);
        Employee employee = new Employee(lastName, firstName, salary, departmentNumber);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already added :(");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        validationOfInput(firstName, lastName);
        String key = firstName + lastName;
        if (employees.containsKey(key)) {
           return employees.remove(key);
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        validationOfInput(firstName, lastName);
        String key = firstName + lastName;
        if (employees.containsKey(key)) {
            return employees.remove(key);
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

    public void addAll () {
        Employee ivanov = new Employee("Ivanov", "Ivan", 50_000, 1);
        Employee petrov = new Employee("Petrov", "Petr", 100_000, 1);
        Employee sidorov = new Employee("Sidorov", "Alexander", 45_000, 2);
        Employee nikolaev = new Employee("Nikolaev", "Nikolay", 39_000,2);
        Employee alexandrov = new Employee("Alexandrov", "Alexander",70_000, 3);
        Employee alexeev = new Employee("Alexeev", "Alexey", 60_000,3);
        Employee sergeev = new Employee("Sergeev", "Seregey", 55_000, 4);
        Employee vasilyev = new Employee("Vasilyev", "Vasiliy", 67_000, 4);
        Employee olgina = new Employee("Olgina", "Olga", 150_000, 5);
        Employee xeneva = new Employee("Xeneva", "Xenia", 200_000, 5);
        employees.put(ivanov.getFullName(), ivanov);
        employees.put(petrov.getFullName(), petrov);
        employees.put(sidorov.getFullName(), sidorov);
        employees.put(nikolaev.getFullName(), nikolaev);
        employees.put(alexandrov.getFullName(), alexandrov);
        employees.put(alexeev.getFullName(), alexeev);
        employees.put(sergeev.getFullName(), sergeev);
        employees.put(vasilyev.getFullName(), vasilyev);
        employees.put(olgina.getFullName(), olgina);
        employees.put(xeneva.getFullName(), xeneva);
    }
}