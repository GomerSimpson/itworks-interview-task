package com.brest.itworks.task.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private List<Task> tasks = new ArrayList<>();

    public Person() {
    }

    public Person(Integer personId, String fullName, String login, String password) {
        this.personId = personId;
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(final Integer personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTask(Task task) {
        task.setPerson(this);
        this.tasks.add(task);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (fullName != null ? !fullName.equals(person.fullName) : person.fullName != null) return false;
        if (login != null ? !login.equals(person.login) : person.login != null) return false;
        if (password != null ? !password.equals(person.password) : person.password != null) return false;
        if (personId != null ? !personId.equals(person.personId) : person.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
