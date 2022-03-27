package com.uptc.cleanXpress.dao.person;

import com.uptc.cleanXpress.models.Person;

import java.util.List;

public interface PersonDao{

    List<Person> getPersons();

    void delete(String id);

    void registerPerson(Person person);
}
