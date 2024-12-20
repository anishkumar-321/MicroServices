package com.services.employee_service.controller;
import com.services.employee_service.model.Employee;
import com.services.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping("/findEmployeeById/{employeeId}")
    public Employee findEmployeeById(@PathVariable Long employeeId){
        return employeeRepository.findEmployeeById(employeeId);
    }

    @GetMapping("/findAllEmployees")
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAllEmployees();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee>findEmployeesByDepartmentId(@PathVariable("departmentId") Long departmentId){
        return employeeRepository.findEmployeesOfOneDepartment(departmentId);
    }

}
