package com.brest.itworks.task.dao;

import com.brest.itworks.task.domain.Task;

import java.util.List;

public interface TaskDao {
    public Integer addTask(final Task task);
    public void updateTask(final Task tempTask);
    public void removeTask(final Integer id);
    public List<Task> getAllTasks();
    public Task getTaskById(final Integer id);
}
