package com.uptc.cleanXpress.dao;

import com.uptc.cleanXpress.models.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImp implements PersonDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getPersons() {
        /**
         * se hace referencia a la clase de java mas no al nombre de la tabla de la DB
         * Se puede colocar condiciones... WHERE
         */
        String query = "FROM Person";
        return entityManager.createQuery(query).getResultList();
    }
}
