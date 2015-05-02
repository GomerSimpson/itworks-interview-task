package com.brest.itworks.task.dao;

import com.brest.itworks.task.domain.Task;
import com.brest.itworks.task.domain.Task_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by simpson on 2.5.15.
 */
public class TaskDaoImpl implements TaskDao {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("persUnit").createEntityManager();

    @Override
    public Integer addTask(Task task) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        return task.getTaskId();
    }

    @Override
    public void updateTask(Task tempTask) {
        entityManager.getTransaction().begin();

        Task task = entityManager.find(Task.class, tempTask.getTaskId());
        task.setName(tempTask.getName());
        task.setState(tempTask.getState());

        entityManager.getTransaction().commit();
    }

    @Override
    public void removeTask(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Task.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Task> getAllTasks() {
        CriteriaQuery<Task> criteria = entityManager.getCriteriaBuilder().createQuery(Task.class);
        Root<Task> tasks = criteria.from(Task.class);
        criteria.select(tasks);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public Task getTaskById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> criteria = criteriaBuilder.createQuery(Task.class);
        Root<Task> tasks = criteria.from(Task.class);
        criteria.select(tasks);
        criteria.where(criteriaBuilder.equal(tasks.get(Task_.taskId), id));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
