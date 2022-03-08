package tn.isima.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.isima.employeemanager.model.Employee;
import tn.isima.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeResource {
    private final EmployeeService employeeService;
   
    
    
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    
    
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

   
}
