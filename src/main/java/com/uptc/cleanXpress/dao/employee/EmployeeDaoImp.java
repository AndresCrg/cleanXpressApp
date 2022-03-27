package com.uptc.cleanXpress.dao.employee;

import com.uptc.cleanXpress.models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImp implements EmployeeDao{
    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void registerPerson(Employee employee) {

    }
}
