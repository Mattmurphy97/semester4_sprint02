package com.keyin.sprint02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CrossOrigin allows the backend to connect with the front end when given the "localhost" port#,
// in this case it is 3000 (react app)
@CrossOrigin(origins = "http://localhost:3000")
@RestController
//@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    // get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    // create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeRepo.getReferenceById(id);
    }

    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee update = employeeRepo.getReferenceById(id);
        update.setFirstName(employee.getFirstName());
        update.setLastName(employee.getLastName());
        update.setEmailId(employee.getEmailId());

        Employee updatedEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
