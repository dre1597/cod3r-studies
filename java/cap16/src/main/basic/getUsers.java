package main.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class getUsers {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java-cap16");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    String jpql = "select u from User u";
    TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

    query.setMaxResults(5);

    List<User> users = query.getResultList();

    for (User user : users) {
      System.out.println("ID: " + user.getId() + " Email: " + user.getEmail());
    }

    entityManager.close();
    entityManagerFactory.close();
  }
}
