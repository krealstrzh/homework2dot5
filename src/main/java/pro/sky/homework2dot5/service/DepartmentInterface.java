package pro.sky.homework2dot5.service;

import java.util.List;

public interface DepartmentInterface {
    Employee findMinSalaryByDep(int depNumber);

    Employee findMaxSalaryByDep(int depNumber);

    List<Employee> findByDep(int depNumber);

    List<Employee> employeeListByDeps();
}
