package com.brest.itworks.task.service;

import com.brest.itworks.task.domain.Log;

import java.util.List;

/**
 * Created by simpson on 2.5.15.
 */
public interface LogService {
    public Integer addLog(final Log log);
    public void updateLog(final Log tempLog);
    public void removeLog(final Integer log);
    public List<Log> getAllLogs();
    public Log getLogById(final Integer id);
}
