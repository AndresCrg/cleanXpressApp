package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.client.ClientDao;
import com.uptc.cleanXpress.models.Client;
import com.uptc.cleanXpress.models.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private ClientDao clientDao;

    @RequestMapping(value = "/api/getClients", method = RequestMethod.GET)
    public List<Client> getClients(){
        return clientDao.getClients();
    }

    @RequestMapping(value = "/api/registerClient", method = RequestMethod.POST)
    public void registerClient(@RequestBody Client client){
        clientDao.registerClient(client);
    }

    @RequestMapping(value = "/api/getPersons/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable String id){clientDao.delete(id);}
}
