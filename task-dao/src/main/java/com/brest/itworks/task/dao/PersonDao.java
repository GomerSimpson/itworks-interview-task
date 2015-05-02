package com.brest.itworks.task.dao;

import com.brest.itworks.task.domain.Person;

import java.util.List;

/**
 * Created by simpson on 30.4.15.
 */
public interface PersonDao {
    public Integer addPerson(final Person person);
    public void updatePerson(final Person person);
    public void removePerson(final Integer id);
    public List<Person> getAllPeople();
    public Person getPersonById(final Integer id);
}
