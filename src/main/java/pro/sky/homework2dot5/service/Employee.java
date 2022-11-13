package pro.sky.homework2dot5.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private String firstName;
    private String lastName;
    private int departmentNumber;
    private int salary;

    public Employee (String firstName, String lastName, int salary, int departmentNumber) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be lower than 0!");
        }
        int maxDepartmentId = 5;
        int minDepartmentId = 1;
        if  (departmentNumber > maxDepartmentId) {
            throw new IllegalArgumentException("There are only 5 departments!");
        } else if (departmentNumber < minDepartmentId) {
            throw new IllegalArgumentException("Department number cannot be lower than 0!");
        } else {
            this.departmentNumber = departmentNumber;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        int maxDepartmentId = 5;
        int minDepartmentId = 1;
        if  (departmentNumber > maxDepartmentId) {
            throw new IllegalArgumentException("There are only 5 departments!");
        } else if (departmentNumber < minDepartmentId) {
            throw new IllegalArgumentException("Department number cannot be lower than 0!");
        } else {
            this.departmentNumber = departmentNumber;
        }
    }

    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be lower than 0!");
        }
    }

    @Override
    public String toString() {
        return this.lastName + " " + this.firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return lastName.equals(employee.lastName) && firstName.equals(employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }
}
