package com.brest.itworks.task.service;

import com.brest.itworks.task.dao.LogDao;
import com.brest.itworks.task.dao.LogDaoImpl;
import com.brest.itworks.task.domain.Log;

import java.util.List;

/**
 * Created by simpson on 2.5.15.
 */
public class LogServiceImpl implements LogService {

    private LogDao logDao = new LogDaoImpl();

    @Override
    public Integer addLog(final Log log) {
        return logDao.addLog(log);
    }

    @Override
    public void updateLog(final Log tempLog) {
        logDao.updateLog(tempLog);
    }

    @Override
    public void removeLog(final Integer log) {
        logDao.removeLog(log);
    }

    @Override
    public List<Log> getAllLogs() {
        return logDao.getAllLogs();
    }

    @Override
    public Log getLogById(final Integer id) {
        return logDao.getLogById(id);
    }
}
