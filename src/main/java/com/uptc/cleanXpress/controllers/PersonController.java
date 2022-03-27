package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.person.PersonDao;
import com.uptc.cleanXpress.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/api/persons", method = RequestMethod.GET)
    public List<Person> getPersons(){
        return personDao.getPersons();
    }

    @RequestMapping(value = "/api/persons", method = RequestMethod.POST)
    public void registerPerson(@RequestBody Person person){
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getAddress());
        System.out.println(person.getPhoneNumber());
        System.out.println(person.getEmail());
        personDao.registerPerson(person);
    }

    @RequestMapping(value = "/api/getPersons/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id){personDao.delete(id);}
}
