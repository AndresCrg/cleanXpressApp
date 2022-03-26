package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.person.PersonDao;
import com.uptc.cleanXpress.models.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonDao personDao;

    @RequestMapping(value = "/api/getPersons", method = RequestMethod.GET)
    public List<Person> getPersons(){
        return personDao.getPersons();
    }

    @RequestMapping(value = "/api/registerPerson", method = RequestMethod.POST)
    public void registerPerson(@RequestBody Person person){
        personDao.registerPerson(person);
    }

    @RequestMapping(value = "/api/getPersons/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id){personDao.delete(id);}
}
