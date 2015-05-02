package com.brest.itworks.task.dao;

import com.brest.itworks.task.domain.Log;

import java.util.List;

public interface LogDao {
    public Integer addLog(final Log log);
    public void updateLog(final Log temlpLog);
    public void removeLog(final Integer log);
    public List<Log> getAllLogs();
    public Log getLogById(final Integer id);
}
