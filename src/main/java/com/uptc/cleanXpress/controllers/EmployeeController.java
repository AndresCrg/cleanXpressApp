package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.employee.EmployeeDao;
import com.uptc.cleanXpress.models.Employee;
import com.uptc.cleanXpress.models.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeDao employeeDao;

    @RequestMapping(value = "/api/getEmployees", method = RequestMethod.GET)
    public List<Employee> getEmployees(){
        return employeeDao.getEmployees();
    }

    @RequestMapping(value = "/api/registerEmployee", method = RequestMethod.POST)
    public void registerEmployee(@RequestBody Employee employee){
        employeeDao.registerEmployee(employee);
    }

    @RequestMapping(value = "/api/getPersons/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id){employeeDao.delete(id);}
}
