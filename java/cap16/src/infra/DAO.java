package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class DAO<E> {

  private static EntityManagerFactory entityManagerFactory;

  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory("java-cap16");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private EntityManager entityManager;
  private Class<E> entityClass;

  public DAO() {
    this(null);
  }


  public DAO(Class<E> entityClass) {
    this.entityClass = entityClass;
    entityManager = entityManagerFactory.createEntityManager();
  }

  public DAO<E> openTransaction() {
    entityManager.getTransaction().begin();
    return this;
  }

  public DAO<E> closeTransaction() {
    entityManager.getTransaction().commit();
    return this;
  }

  public DAO<E> persistEntity(E entity) {
    entityManager.persist(entity);
    return this;
  }

  public DAO<E> atomicPersist(E entity) {
    return this.openTransaction().persistEntity(entity).closeTransaction();
  }

  public List<E> findAll() {
    return this.findAll(10, 0);
  }

  public List<E> findAll(int limit, int offset) {
    if (entityClass == null) {
      throw new UnsupportedOperationException("Null entity class");
    }

    String jpql = "select e from " + entityClass.getName() + " e";
    TypedQuery<E> query = entityManager.createQuery(jpql, entityClass);
    query.setMaxResults(limit);
    query.setFirstResult(offset);
    return query.getResultList();
  }

  public E findByID(Object id) {
    return entityManager.find(entityClass, id);
  }

  public List<E> consult(String consultName, Object... params) {
    TypedQuery<E> query = entityManager.createNamedQuery(consultName, entityClass);

    for (int i = 0; i < params.length; i += 2) {
      query.setParameter(params[i].toString(), params[i + 1]);
    }

    return query.getResultList();
  }

  public E consultOne(String consultName, Object... params) {
    List<E> list = consult(consultName, params);
    return list.isEmpty() ? null : list.get(0);
  }

  public void close() {
    entityManager.close();
  }
}
