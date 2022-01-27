package be.intec.springcookbookop02.repositories;


import be.intec.springcookbookop02.models.Employee;
import be.intec.springcookbookop02.models.Employees;

public interface IEmployeeRepository {

    Employees getAllEmployees();
    void updateEmployeeFullName( Integer id, String firstName, String lastName
    );
    void addEmployee( Employee employee );
    void removeEmployee( Employee employee );

    void deleteEmployee(Integer id);
}