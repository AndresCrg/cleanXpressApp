package com.uptc.cleanXpress.dao.client;

import com.uptc.cleanXpress.models.Client;
import com.uptc.cleanXpress.models.Person;
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
        List<Client> clients = entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        return clients;
    }

    @Override
    public void delete(String id) {
        Client client = entityManager.find(Client.class, id);
        entityManager.remove(client);
    }

    @Override
    public void registerClient(Client client) {
        entityManager.merge(client);
    }
}
