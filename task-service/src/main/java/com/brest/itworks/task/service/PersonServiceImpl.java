package com.brest.itworks.task.service;

import com.brest.itworks.task.dao.PersonDao;
import com.brest.itworks.task.dao.PersonDaoImpl;
import com.brest.itworks.task.domain.Person;

import java.util.List;

/**
 * Created by simpson on 2.5.15.
 */
public class PersonServiceImpl implements PersonService {

    PersonDao personDao = new PersonDaoImpl();

    @Override
    public Integer addPerson(final Person person) {
        return personDao.addPerson(person);
    }

    @Override
    public void updatePerson(final Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void removePerson(final Integer id) {
        personDao.removePerson(id);
    }

    @Override
    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    @Override
    public Person getPersonById(final Integer id) {
        return personDao.getPersonById(id);
    }
}
