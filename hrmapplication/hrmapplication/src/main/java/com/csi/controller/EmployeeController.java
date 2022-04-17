package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    EmployeeRepo employeeRepoImpl;


    @GetMapping("/")
    public List<Employee> getAllData()
    {
        return employeeServiceImpl.getAllData();
    }

    @GetMapping("/{empId}")
    public Optional<Employee> getDataById(@PathVariable int empId){
        return employeeServiceImpl.getDataById(empId);
    }

    @PostMapping("/")
    public Employee saveData(@RequestBody Employee employee){
        return employeeServiceImpl.saveData(employee);
    }

    @PutMapping("/{empId}")
    public Employee updateData(@PathVariable int empId, @RequestBody Employee employee) throws RecordNotFoundException {
      //

        Employee employee1=employeeRepoImpl.findById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Id Does not exist"));

     
        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpLastName(employee.getEmpLastName());
        employee1.setEmpEmailId(employee.getEmpEmailId());

        return employeeServiceImpl.updateData(employee1);

    }

    @DeleteMapping("/{empId}")
    public String deleteData(@PathVariable int empId)
    {
        employeeServiceImpl.deleteData(empId);
        return "Data Deleted Successfully";
    }
}
