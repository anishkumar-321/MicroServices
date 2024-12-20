package com.services.employee_service.repository;

import com.services.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    public Employee addEmployee(Employee employee){
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> findAllEmployees(){
        return employeeList;
    }

    public Employee findEmployeeById(Long employeeId){
        return employeeList.stream().filter(
                        department->
                                department.getId().equals(employeeId))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findEmployeesOfOneDepartment(Long departmentId){
        return employeeList.stream()
                .filter(employee->employee.getDepartmentId().equals(departmentId))
                .toList();
    }
}
