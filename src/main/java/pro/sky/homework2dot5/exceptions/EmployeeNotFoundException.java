package pro.sky.homework2dot5.exceptions;

public class EmployeeNotFoundException extends Throwable{

    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}