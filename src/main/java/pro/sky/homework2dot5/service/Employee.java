package pro.sky.homework2dot5.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.*;

public class Employee {
    private String lastName;
    private String firstName;
    private int departmentNumber;
    private int salary;

    public Employee (String lastName, String firstName, int salary, int departmentNumber) {
        this.lastName = capitalize(lastName.toLowerCase());
        this.firstName = capitalize(firstName.toLowerCase());
        this.salary = salary;
        this.departmentNumber = departmentNumber;
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
        if (departmentNumber <= maxDepartmentId || departmentNumber >= minDepartmentId) {
            this.departmentNumber = departmentNumber;
        } else if (departmentNumber > maxDepartmentId) {
            throw new IllegalArgumentException("There are only 5 departments!");
        } else if (departmentNumber < minDepartmentId) {
            throw new IllegalArgumentException("Department number cannot be lower than 0!");
        }
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
