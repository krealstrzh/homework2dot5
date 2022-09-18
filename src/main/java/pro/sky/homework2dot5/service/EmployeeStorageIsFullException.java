package pro.sky.homework2dot5.service;

public class EmployeeStorageIsFullException extends Throwable {

    public EmployeeStorageIsFullException(String s) {
        super (s);
    }
}
