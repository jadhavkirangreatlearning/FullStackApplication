package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepoImpl;


    public List<Employee> getAllData() {
        return employeeRepoImpl.findAll();
    }

    public Optional<Employee> getDataById(int empId) {
        return employeeRepoImpl.findById(empId);
    }

    public Employee saveData(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public Employee updateData(Employee employee1) {
        return employeeRepoImpl.save(employee1);
    }

    public void deleteData(int empId) {
        employeeRepoImpl.deleteById(empId);
    }
}
