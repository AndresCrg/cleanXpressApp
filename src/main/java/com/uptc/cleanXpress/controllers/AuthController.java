package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.client.ClientDao;
import com.uptc.cleanXpress.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    ClientDao clientDao;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody Client client){
       if (clientDao.checkDataLogin(client)) {
           return "Session-Client";
       }else{
           return "Session-Admin";
       }
    }
}
