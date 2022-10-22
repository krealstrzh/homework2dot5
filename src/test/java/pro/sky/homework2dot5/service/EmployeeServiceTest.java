package pro.sky.homework2dot5.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.homework2dot5.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework2dot5.exceptions.EmployeeNotFoundException;
import pro.sky.homework2dot5.exceptions.InvalidInputException;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.homework2dot5.service.Constants.*;

class EmployeeServiceTest {

    private final EmployeeService out = new EmployeeService();

    public static final Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(CORRECT_FIRSTNAME, CORRECT_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER),
                Arguments.of(LOWERCASE_FIRSTNAME, LOWERCASE_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER),
                Arguments.of(UPPERCASE_FIRSTNAME, UPPERCASE_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER)
        );
    }
    public static final Stream<Arguments> invalidInputsForSearchingAndDeleting() {
        return Stream.of(
                Arguments.of(CORRECT_FIRSTNAME, ILLEGAL_CHARACTERS_LASTNAME),
                Arguments.of(ILLEGAL_CHARACTERS_FIRSTNAME, UPPERCASE_LASTNAME)
        );
    }

    @Test
    void shouldThrowExceptionWithIllegalInputsWhenAdding() {
        assertThrows(InvalidInputException.class,
                () -> out.addEmployee(ILLEGAL_CHARACTERS_FIRSTNAME, CORRECT_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER));
        assertThrows(InvalidInputException.class,
                () -> out.addEmployee(CORRECT_FIRSTNAME, ILLEGAL_CHARACTERS_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER));
        assertThrows(IllegalArgumentException.class,
                () -> out.addEmployee(CORRECT_FIRSTNAME, CORRECT_FIRSTNAME, LOW_SALARY, CORRECT_DEPNUMBER));
        assertThrows(IllegalArgumentException.class,
                () -> out.addEmployee(CORRECT_FIRSTNAME, CORRECT_FIRSTNAME, CORRECT_SALARY, LOW_DEPNUMBER));
        assertThrows(IllegalArgumentException.class,
                () -> out.addEmployee(CORRECT_FIRSTNAME, CORRECT_FIRSTNAME, CORRECT_SALARY, HIGH_DEPNUMBER));

    }

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldAddNewEmployees(String firstName, String lastName, int salary, int depNumber) throws EmployeeAlreadyAddedException {
        Employee expected = new Employee (firstName, lastName, salary, depNumber);
        assertEquals(out.addEmployee(firstName, lastName, salary, depNumber), expected);
    }

    @Test
    void shouldThrowExceptionAlreadyAdded() throws EmployeeAlreadyAddedException {
        out.addEmployee(CORRECT_FIRSTNAME, CORRECT_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(CORRECT_FIRSTNAME, CORRECT_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER));
    }

    @ParameterizedTest
    @MethodSource("invalidInputsForSearchingAndDeleting")
    void shouldThrowInvalidInputExceptionWhenDeletingOrSearching(String firstName, String lastName) {
        assertThrows(InvalidInputException.class,
                () -> out.deleteEmployee(firstName, lastName));
        assertThrows(InvalidInputException.class,
                () -> out.findEmployee(firstName, lastName));

    }

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldFindEmployees(String firstName, String lastName, int salary, int depNumber) throws EmployeeNotFoundException, EmployeeAlreadyAddedException {
        Employee expected = new Employee (firstName, lastName, salary, depNumber);
        out.addEmployee(firstName, lastName, salary, depNumber);
        assertEquals(out.findEmployee(firstName, lastName), expected);
    }

    @Test
    void shouldThrowNotFound() throws EmployeeAlreadyAddedException {
        out.addEmployee(CORRECT_FIRSTNAME, CORRECT_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER);
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(CORRECT_FIRSTNAME, UPPERCASE_LASTNAME));
        assertThrows(EmployeeNotFoundException.class,
                () -> out.deleteEmployee(LOWERCASE_FIRSTNAME, UPPERCASE_LASTNAME));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void deleteEmployee(String firstName, String lastName, int salary, int depNumber) throws EmployeeAlreadyAddedException, EmployeeNotFoundException {
        Employee expected = new Employee (firstName, lastName, salary, depNumber);
        out.addEmployee(firstName, lastName, salary, depNumber);
        assertEquals(out.deleteEmployee(firstName, lastName), expected);
    }

    @Test
    void findAll() throws EmployeeAlreadyAddedException {
        List <Employee> expected = List.of(
                new Employee(CORRECT_FIRSTNAME, CORRECT_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER),
                new Employee(LOWERCASE_FIRSTNAME, LOWERCASE_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER),
                new Employee(UPPERCASE_FIRSTNAME, UPPERCASE_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER)
        );
        out.addEmployee(CORRECT_FIRSTNAME, CORRECT_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER);
        out.addEmployee(LOWERCASE_FIRSTNAME, LOWERCASE_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER);
        out.addEmployee(UPPERCASE_FIRSTNAME, UPPERCASE_LASTNAME, CORRECT_SALARY, CORRECT_DEPNUMBER);
        assertEquals(out.findAll(), expected);
    }

}