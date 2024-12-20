package com.services.department_service.controller;
import com.services.department_service.client.EmployeeClient;
import com.services.department_service.model.Department;
import com.services.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
  private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping("/findAllDepartments")
     public List<Department> findAllDepartments(){
         return departmentRepository.findAll();
     }

     @GetMapping("/findDepartmentById/{id}")
     public Department findDepartmentById(@PathVariable Long id){
         return departmentRepository.findDepartmentById(id);
     }

     @PostMapping("/postDepartmentData")
    public Department postDepartmentData(@RequestBody Department department){
        return departmentRepository.addDepartment(department);
     }

     @GetMapping("/findEmployeesBelongsToThatDepartment")
     public List<Department>findEmployeesBelongsToOneDepartment(){
        List<Department>departments=departmentRepository.findAll();
         System.out.println(departments);
         departments.forEach(
                department->department.setEmployees(
                        employeeClient.findEmployeesByDepartmentId(department.getId())

                )
        );
        System.out.println(departments);
        return departments;
     }


}
