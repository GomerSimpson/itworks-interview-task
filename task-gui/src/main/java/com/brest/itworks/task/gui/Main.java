package com.brest.itworks.task.gui;

import com.brest.itworks.task.dao.PersonDao;
import com.brest.itworks.task.dao.PersonDaoImpl;
import com.brest.itworks.task.domain.Log;
import com.brest.itworks.task.domain.Person;
import com.brest.itworks.task.domain.Task;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main extends Application {

    private static PersonDao personDao = new PersonDaoImpl();

    private static void print(Object parameter){
        System.out.println(parameter);
    }

    private static void fillDb(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;
        try{
            et = em.getTransaction();
            et.begin();
            Person person1 = new Person(null, "GJS1", "login1", "password1");
            Person person2 = new Person(null, "GJS2", "login2", "password2");
            Person person3 = new Person(null, "GJS3", "login3", "password3");
            Task task1 = new Task(null, "task1", true);
            Task task2 = new Task(null, "task2", false);
            Task task3 = new Task(null, "task3", true);
            Log log1 = new Log(null, 1, "message1");
            Log log2 = new Log(null, 2, "message2");
            Log log3 = new Log(null, 3, "message3");

            task2.setLogs(log1);
            task3.setLogs(log2);
            task3.setLogs(log3);

            person2.setTask(task1);
            person3.setTask(task2);
            person3.setTask(task3);
            em.persist(person1);
            em.persist(person2);
            em.persist(person3);
            //em.remove(em.find(Person.class, 9));
            et.commit();


        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        //print(personDao.addPerson(new Person(null, "GJS4", "login4", "password4")));
        //personDao.updatePerson(new Person(15, "GJS3", "login3", "password3"));
        //personDao.removePerson(16);
        print(personDao.getAllPeople().get(2).getTasks().get(1).getLogs());

    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/test.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        stage.setTitle(new Person().toString());
        stage.setScene(new Scene(root));
        stage.show();
    }
}