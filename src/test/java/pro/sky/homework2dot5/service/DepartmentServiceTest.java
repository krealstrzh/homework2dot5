package pro.sky.homework2dot5.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.homework2dot5.service.Constants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    private final EmployeeService employeeMock = mock(EmployeeService.class);

    @InjectMocks
    private DepartmentService out;

    public static final Stream<Arguments> depNumbers() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(4),
                Arguments.of(5)
        );
    }

    public static final Stream<Arguments> wrongDepNumbers() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(255),
                Arguments.of(256),
                Arguments.of(-255)
        );
    }

    @ParameterizedTest
    @MethodSource("depNumbers")
    void shouldReturnMinSalaryByDep(int depNumber) {
        when(employeeMock.findAll())
                .thenReturn(MOCK_LIST);
        Employee expected = MOCK_LIST.stream()
                .filter(d -> d.getDepartmentNumber() == depNumber)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
        assertEquals(expected, out.findMaxSalaryByDep(depNumber));
    }

    @ParameterizedTest
    @MethodSource("depNumbers")
    void shouldReturnMaxSalaryByDep(int depNumber) {
        when(employeeMock.findAll())
                .thenReturn(MOCK_LIST);
        Employee expected = MOCK_LIST.stream()
                .filter(d -> d.getDepartmentNumber() == depNumber)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
        assertEquals(expected, out.findMaxSalaryByDep(depNumber));
    }

    @ParameterizedTest
    @MethodSource("depNumbers")
    void shouldReturnListOfDepartment(int depNumber) {
        when(employeeMock.findAll())
                .thenReturn(MOCK_LIST);
        List<Employee> expected = MOCK_LIST.stream()
                .filter(d -> d.getDepartmentNumber() == depNumber)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(expected, out.findByDep(depNumber));
    }

    @ParameterizedTest
    @MethodSource("wrongDepNumbers")
    void shouldThrowExceptionWhenDepNumIsWrong(int depNumber) {
        when(employeeMock.findAll())
                .thenReturn(MOCK_LIST);
        assertThrows(IllegalArgumentException.class,
                () -> out.findMinSalaryByDep(depNumber));
        assertThrows(IllegalArgumentException.class,
                () -> out.findMaxSalaryByDep(depNumber));
        assertThrows(IllegalArgumentException.class,
                () -> out.findByDep(depNumber));
    }

    @Test
    void shouldReturnListOfAllEmployeesSorted() {
        when(employeeMock.findAll())
                .thenReturn(MOCK_LIST);
        List<Employee> expected = MOCK_LIST.stream()
                .sorted(Comparator.comparingInt(d -> d.getDepartmentNumber()))
                .collect(Collectors.toUnmodifiableList());
        assertEquals(expected, out.employeeListByDeps());

    }
}