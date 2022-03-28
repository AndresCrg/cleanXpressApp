package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.person.PersonDao;
import com.uptc.cleanXpress.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/api/persons", method = RequestMethod.GET)
    public List<Person> getPersons(){
        return personDao.getPersons();
    }

    @RequestMapping(value = "/api/persons", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> registerPerson(@RequestBody Person person){
        personDao.registerPerson(person);
        Map<String, String> response = new HashMap<>();
        response.put("msg","ok");
        return response;
    }

    @RequestMapping(value = "/api/getPersons/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id){personDao.delete(id);}
}
