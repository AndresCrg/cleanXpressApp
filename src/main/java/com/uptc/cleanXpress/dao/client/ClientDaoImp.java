package com.uptc.cleanXpress.dao.client;

import com.uptc.cleanXpress.models.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ClientDaoImp implements ClientDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> getClients() {
        String query = "FROM Client";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(String id) {
        Client client = entityManager.find(Client.class, id);
        entityManager.remove(client);
    }

    @Override
    public void registerClient(Client client) {
        entityManager.persist(client);
    }
}
