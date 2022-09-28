package main.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java-cap16");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    User newUser = new User("Name1", "name@email.com");

    entityManager.getTransaction().begin();
    entityManager.persist(newUser);
    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();
  }
}
