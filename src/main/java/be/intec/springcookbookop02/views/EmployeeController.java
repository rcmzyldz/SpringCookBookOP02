package be.intec.springcookbookop02.views;
import java.net.URI;

import be.intec.springcookbookop02.models.Employee;
import be.intec.springcookbookop02.models.Employees;
import be.intec.springcookbookop02.repositories.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {


    private final IEmployeeRepository employeeRepo;

  // @RequestMapping(method = RequestMethod.GET, path="/get-all", produces = "application/json")
    @GetMapping(path="/get-all", produces = "application/json")
    public Employees getEmployees() {

        return employeeRepo.getAllEmployees();

    }

    @PostMapping(path= "/create-one", consumes = "application/json", produces =
            "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

        Integer id = employeeRepo.getAllEmployees().getEmployeeList().size() +
                1;
        employee.setId(id);
        employeeRepo.addEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/delete-one/{id}")
    public void deleteEmployee(@PathVariable(name = "id") Integer id){
        employeeRepo.deleteEmployee(id);
    }
}