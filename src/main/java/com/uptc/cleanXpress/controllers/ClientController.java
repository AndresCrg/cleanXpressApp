package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.client.ClientDao;
import com.uptc.cleanXpress.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientDao clientDao;

    @RequestMapping(value = "api/clients", method = RequestMethod.GET)
    public List<Client> getClients(){ return clientDao.getClients();}

    @RequestMapping(value = "/api/clients", method = RequestMethod.POST)
    public void registerClient(@RequestBody Client client){
        System.out.println("dwwedw" + client.getAddress());
        clientDao.registerClient(client);
    }

    @RequestMapping(value = "/api/clients/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable String id){clientDao.delete(id);}
}
