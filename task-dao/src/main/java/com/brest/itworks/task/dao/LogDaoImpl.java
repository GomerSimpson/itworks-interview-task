package com.brest.itworks.task.dao;

import com.brest.itworks.task.domain.Log;
import com.brest.itworks.task.domain.Log_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by simpson on 2.5.15.
 */
public class LogDaoImpl implements LogDao {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("persUnit").createEntityManager();

    @Override
    public Integer addLog(final Log log) {
        entityManager.getTransaction().begin();
        entityManager.persist(log);
        entityManager.getTransaction().commit();
        return log.getLogId();
    }

    @Override
    public void updateLog(Log tempLog) {
        entityManager.getTransaction().begin();

        Log log = entityManager.find(Log.class, tempLog.getLogId());
        log.setComment(tempLog.getComment());
        log.setSpentTime(tempLog.getSpentTime());

        entityManager.getTransaction().commit();
    }

    @Override
    public void removeLog(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Log.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Log> getAllLogs() {
        CriteriaQuery<Log> criteria = entityManager.getCriteriaBuilder().createQuery(Log.class);
        Root<Log> logs = criteria.from(Log.class);
        criteria.select(logs);

        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public Log getLogById(Integer id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Log> criteria = criteriaBuilder.createQuery(Log.class);
        Root<Log> logs = criteria.from(Log.class);
        criteria.select(logs);
        criteria.where(criteriaBuilder.equal(logs.get(Log_.logId), id));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
