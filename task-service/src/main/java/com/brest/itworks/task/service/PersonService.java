package com.brest.itworks.task.service;

import com.brest.itworks.task.domain.Person;

import java.util.List;

/**
 * Created by simpson on 2.5.15.
 */
public interface PersonService {
    public Integer addPerson(final Person person);
    public void updatePerson(final Person person);
    public void removePerson(final Integer id);
    public List<Person> getAllPeople();
    public Person getPersonById(final Integer id);
}
