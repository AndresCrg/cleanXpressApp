package com.uptc.cleanXpress.dao.person;

import com.uptc.cleanXpress.dao.person.PersonDao;
import com.uptc.cleanXpress.models.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImp implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getPersons() {
        /**
         * se hace referencia a la clase de java mas no al nombre de la tabla de la DB
         * Se puede colocar condiciones... WHERE
         */
        String query = "FROM Person";
        System.out.println(entityManager.createQuery(query).getResultList());
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registerPerson(Person person) {
        entityManager.merge(person);
    }

    @Override
    public void delete(String id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }
}
