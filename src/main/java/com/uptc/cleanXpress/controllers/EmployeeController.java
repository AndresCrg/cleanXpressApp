package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.employee.EmployeeDao;
import com.uptc.cleanXpress.models.Employee;
import com.uptc.cleanXpress.models.Person;
import com.uptc.cleanXpress.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/api/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return employeeDao.getEmployees();
    }

    @RequestMapping(value = "/api/employees", method = RequestMethod.POST)
    public void registerEmployee(@RequestBody Employee employee){
        employeeDao.registerEmployee(employee);
    }

    @RequestMapping(value = "/api/employees/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable String id){employeeDao.delete(id);}
}
