package com.uptc.cleanXpress.dao.client;

import com.uptc.cleanXpress.models.Client;

import java.util.List;

public interface ClientDao {
    List<Client> getClients();

    void delete(String id);

    void registerClient(Client client);
}
