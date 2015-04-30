package com.brest.itworks.task.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "state", nullable = false)
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private List<Log> logs = new ArrayList<>();

    public Task() {
    }

    public Task(final Integer taskId, final String name, final Boolean state) {
        this.taskId = taskId;
        this.name = name;
        this.state = state;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(final Integer taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(final Boolean state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(final Log log) {
        log.setTask(this);
        this.logs.add(log);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (state != null ? !state.equals(task.state) : task.state != null) return false;
        if (taskId != null ? !taskId.equals(task.taskId) : task.taskId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId != null ? taskId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
