package main.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteUser {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java-cap16");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    User user = entityManager.find(User.class, 3L);

    if (user != null) {
      entityManager.getTransaction().begin();
      entityManager.remove(user);
      entityManager.getTransaction().commit();
    }

    entityManager.close();
    entityManagerFactory.close();
  }
}
