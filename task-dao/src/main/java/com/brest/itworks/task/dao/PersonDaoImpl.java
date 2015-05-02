package com.brest.itworks.task.dao;

import com.brest.itworks.task.domain.Person;
import com.brest.itworks.task.domain.Person_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("persUnit").createEntityManager();

    @Override
    public Integer addPerson(final Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        return person.getPersonId();
    }

    @Override
    public void updatePerson(Person tempPerson) {
        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class, tempPerson.getPersonId());
        person.setLogin(tempPerson.getLogin());
        person.setFullName(tempPerson.getFullName());
        person.setPassword(tempPerson.getPassword());

        entityManager.getTransaction().commit();
    }

    @Override
    public void removePerson(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Person.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Person> getAllPeople() {
        CriteriaQuery<Person> criteria = entityManager.getCriteriaBuilder().createQuery(Person.class);
        Root<Person> people = criteria.from(Person.class);
        criteria.select(people);

        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public Person getPersonById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = criteriaBuilder.createQuery(Person.class);
        Root<Person> people = criteria.from(Person.class);
        criteria.select(people);
        criteria.where(criteriaBuilder.equal(people.get(Person_.personId), id));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
