package com.brest.itworks.task.domain;

import javax.persistence.*;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @Column(name = "log_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer logId;

    @Column(name = "spent_time", nullable = false)
    private Integer spentTime;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Log(){

    }

    public Log(final Integer logId, final Integer spentTime, final String comment) {
        this.logId = logId;
        this.spentTime = spentTime;
        this.comment = comment;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(final Integer logId) {
        this.logId = logId;
    }

    public Integer getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(final Integer spentTime) {
        this.spentTime = spentTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(final Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Log log = (Log) o;

        if (comment != null ? !comment.equals(log.comment) : log.comment != null) return false;
        if (logId != null ? !logId.equals(log.logId) : log.logId != null) return false;
        if (spentTime != null ? !spentTime.equals(log.spentTime) : log.spentTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (spentTime != null ? spentTime.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", spentTime=" + spentTime +
                ", comment='" + comment + '\'' +
                '}';
    }
}
