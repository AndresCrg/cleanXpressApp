package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.PersonDao;
import com.uptc.cleanXpress.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/getPersons")
    public List<Person> getPersons(){
        return personDao.getPersons();
    }
}
