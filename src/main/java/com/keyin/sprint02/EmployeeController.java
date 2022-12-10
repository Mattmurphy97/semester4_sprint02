package com.keyin.sprint02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
