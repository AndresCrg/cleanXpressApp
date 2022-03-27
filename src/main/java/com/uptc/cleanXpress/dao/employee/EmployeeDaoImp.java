package com.uptc.cleanXpress.dao.employee;

import com.uptc.cleanXpress.models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImp implements EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        String query = "FROM Employee";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(String id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public void registerEmployee(Employee employee) {
        entityManager.persist(employee);
    }
}
