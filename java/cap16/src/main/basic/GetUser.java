package main.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetUser {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java-cap16");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    User user = entityManager.find(User.class, 1L);
    System.out.println(user.getName());

    entityManager.close();
    entityManagerFactory.close();
  }
}

