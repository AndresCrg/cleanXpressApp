package com.uptc.cleanXpress.dao.employee;

import com.uptc.cleanXpress.models.Employee;
import com.uptc.cleanXpress.models.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class EmployeeDaoImp implements EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        return entityManager.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    public void delete(String id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public void registerEmployee(Employee employee) {
        entityManager.merge(employee);
    }
}
