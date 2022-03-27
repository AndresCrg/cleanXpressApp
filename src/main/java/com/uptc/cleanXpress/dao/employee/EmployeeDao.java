package com.uptc.cleanXpress.dao.employee;

import com.uptc.cleanXpress.models.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getEmployees();

    void delete(String id);

    void registerEmployee(Employee employee);
}
