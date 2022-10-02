package main.inheritance;

import infra.DAO;
import model.inheritance.SpecialStudent;
import model.inheritance.Student;

public class NewStudent {
  public static void main(String[] args) {
    DAO<Student> studentDAO = new DAO<>();

    Student student1 = new Student(123L, "João");
    SpecialStudent student2 = new SpecialStudent(345L, "Maria", 1000);

    studentDAO.atomicPersist(student1);
    studentDAO.atomicPersist(student2);

    studentDAO.close();
  }
}
