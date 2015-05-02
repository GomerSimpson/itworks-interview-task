package com.brest.itworks.task.service;

import com.brest.itworks.task.dao.TaskDao;
import com.brest.itworks.task.dao.TaskDaoImpl;
import com.brest.itworks.task.domain.Task;

import java.util.List;

/**
 * Created by simpson on 2.5.15.
 */
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao = new TaskDaoImpl();

    @Override
    public Integer addTask(Task task) {
        return taskDao.addTask(task);
    }

    @Override
    public void updateTask(Task tempTask) {
        taskDao.updateTask(tempTask);
    }

    @Override
    public void removeTask(Integer id) {
taskDao.removeTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public Task getTaskById(Integer id) {
        return taskDao.getTaskById(id);
    }
}
