package pro.sky.homework2dot5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework2dot5.service.DepartmentInterface;
import pro.sky.homework2dot5.service.Employee;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    public final DepartmentInterface departmentInterface;

    public DepartmentController(DepartmentInterface departmentInterface) {
        this.departmentInterface = departmentInterface;
    }

    @GetMapping("/min-salary")
    public Employee minSalaryByDep(@RequestParam int departmentId) {
        return departmentInterface.findMinSalaryByDep(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryByDep(@RequestParam int departmentId) {
        return departmentInterface.findMinSalaryByDep(departmentId);
    }

    @GetMapping (value = "/all", params = {"departmentId"})
    public List <Employee> findByDep(@RequestParam int departmentId) {
        return departmentInterface.findByDep(departmentId);
    }

    @GetMapping ("/all")
    public List <Employee> listByDeps() {
        return departmentInterface.employeeListByDeps();
    }
}
