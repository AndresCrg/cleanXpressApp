package com.uptc.cleanXpress.dao.service;

import com.uptc.cleanXpress.models.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ServiceDaoImp implements ServiceDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Service> getServices() {
        String query = "FROM Service";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void removeService(String id) {
        Service service = entityManager.find(Service.class, id);
        entityManager.remove(service);
    }

    @Override
    public void registerService(Service service) {
        entityManager.merge(service);
    }
}
