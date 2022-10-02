package pro.sky.homework2dot5.service;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeInterface {
    private final Map <String, Employee> employees;

    public EmployeeService (List <Employee> employees) {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already added :(");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
           return employees.remove(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(lastName, firstName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Not found!");
        }
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    public void addAll () {
        Employee ivanov = new Employee("Ivanov", "Ivan");
        ivanov.setSalary(50_000);
        ivanov.setDepartmentNumber(1);
        Employee petrov = new Employee("Petrov", "Petr");
        petrov.setSalary(100_000);
        petrov.setDepartmentNumber(1);
        Employee sidorov = new Employee("Sidorov", "Alexander");
        sidorov.setSalary(45_000);
        sidorov.setDepartmentNumber(2);
        Employee nikolaev = new Employee("Nikolaev", "Nikolay");
        nikolaev.setSalary(39_000);
        nikolaev.setDepartmentNumber(2);
        Employee alexandrov = new Employee("Alexandrov", "Alexander");
        alexandrov.setSalary(70_000);
        alexandrov.setDepartmentNumber(3);
        Employee alexeev = new Employee("Alexeev", "Alexey");
        alexeev.setSalary(60_000);
        alexeev.setDepartmentNumber(3);
        Employee sergeev = new Employee("Sergeev", "Seregey");
        sergeev.setSalary(55_000);
        sergeev.setDepartmentNumber(4);
        Employee vasilyev = new Employee("Vasilyev", "Vasiliy");
        vasilyev.setSalary(67_000);
        vasilyev.setDepartmentNumber(4);
        Employee olgina = new Employee("Olgina", "Olga");
        olgina.setDepartmentNumber(5);
        olgina.setSalary(150_000);
        Employee xeneva = new Employee("Xeneva", "Xenia");
        xeneva.setSalary(200_000);
        xeneva.setDepartmentNumber(5);
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