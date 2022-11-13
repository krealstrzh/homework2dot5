package pro.sky.homework2dot5.service;

import java.util.List;

public class Constants {

    public static final String ILLEGAL_CHARACTERS_FIRSTNAME = "Ivan123";
    public static final String CORRECT_FIRSTNAME = "Jack";
    public static final String LOWERCASE_FIRSTNAME = "john";
    public static final String UPPERCASE_FIRSTNAME = "NAME";
    public static final String ILLEGAL_CHARACTERS_LASTNAME = "Ivanov!!";
    public static final String CORRECT_LASTNAME = "Doe";
    public static final String LOWERCASE_LASTNAME = "galt";
    public static final String UPPERCASE_LASTNAME = "CARDHOLDER";
    public static final int HIGH_DEPNUMBER = 99;
    public static final int LOW_DEPNUMBER = -3;
    public static final int CORRECT_DEPNUMBER = 3;
    public static final int LOW_SALARY = -43434;
    public static final int CORRECT_SALARY = 434343;

    public static final List<Employee> MOCK_LIST = List.of(
            new Employee("Ivan", "Ivanov", 50_000, 1),
            new Employee("Petr", "Petrov", 100_000, 1),
            new Employee("Alexander", "Sidorov", 45_000, 2),
            new Employee("Nikolay", "Nikolaev", 39_000,2),
            new Employee("Alexander", "Alexandrov",70_000, 3),
            new Employee("Alexey", "Alexeev", 60_000,3),
            new Employee("Sergey", "Seregeev", 55_000, 4),
            new Employee("Vasiliy", "Vasilyev", 67_000, 4),
            new Employee("Olga", "Olgina", 150_000, 5),
            new Employee("Xenia", "Xeneva", 200_000, 5)
    );
}
