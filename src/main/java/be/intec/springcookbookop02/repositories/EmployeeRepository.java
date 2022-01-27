package be.intec.springcookbookop02.repositories;


import be.intec.springcookbookop02.models.Employee;
import be.intec.springcookbookop02.models.Employees;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
public class EmployeeRepository implements IEmployeeRepository {
    private static final Employees list = new Employees();
    static {
        list.getEmployeeList().add( new Employee( 1, "Justin", "Bieber",
                "just@in.be" ) );
        list.getEmployeeList().add( new Employee( 2, "Nikola", "Tesla",
                "nikola@tesla.com" ) );
        list.getEmployeeList().add( new Employee( 3, "Marie", "Curie",
                "marie@curie.net" ) );
    }
    public Employees getAllEmployees() {
        return list;
    }
    public void updateEmployeeFullName( Integer id, String firstName, String
            lastName ) {
        for ( int employeeIndex = 0; employeeIndex <
                list.getEmployeeList().size(); employeeIndex++ ) {
            final boolean idsMatch = list.getEmployeeList().get( employeeIndex
            ).getId().equals( id );
            if ( idsMatch ) {
                list.getEmployeeList().get( employeeIndex ).setFirstName(
                        firstName );
                list.getEmployeeList().get( employeeIndex ).setLastName(
                        lastName );
                break;
            }
        }
    }
    public void addEmployee( Employee employee ) {
        list.getEmployeeList().add( employee );
    }
    public void removeEmployee( Employee employee ) {
        list.getEmployeeList().remove( employee );
    }

    @Override
    public void deleteEmployee(Integer id) {
       list.setEmployeeList(
               list.getEmployeeList()
                       .stream()
                       .filter(employee ->employee.getId() != id)
                       .collect(Collectors.toList()));


    }
}