package main.basic;

import model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUser1 {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java-cap16");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    // The detach method is the remove the instance from the manager, soo you'll need the merge method to save the update
    // without the detach method the update will be saved even without the merge method

    entityManager.getTransaction().begin();

    User user = entityManager.find(User.class, 1L);
//    entityManager.detach(user);
    user.setEmail("name1@email.com");
    entityManager.merge(user);

    entityManager.getTransaction().commit();

    entityManager.close();
    entityManagerFactory.close();
  }
}
