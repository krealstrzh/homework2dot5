package pro.sky.homework2dot5.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentInterface {
    public final EmployeeInterface employeeService;

    public DepartmentService(EmployeeInterface employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMinSalaryByDep(int depNumber) {
        return employeeService.findAll().stream()
                .filter(d -> d.getDepartmentNumber() == depNumber)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow();
    }

    public Employee findMaxSalaryByDep(int depNumber) {
        return employeeService.findAll().stream()
                .filter(d -> d.getDepartmentNumber() == depNumber)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow();
    }

    public List <Employee> findByDep(int depNumber) {
        return employeeService.findAll().stream()
                .filter(d -> d.getDepartmentNumber() == depNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Employee> employeeListByDeps() {
        return employeeService.findAll().stream()
                .sorted(Comparator.comparingInt(d -> d.getDepartmentNumber()))
                .collect(Collectors.toUnmodifiableList());
    }
}
