package model.onetoone;

import javax.persistence.*;

@Entity
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne(mappedBy = "seat")
  private Costumer costumer;

  public Seat() {

  }

  public Seat(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Costumer getCostumer() {
    return costumer;
  }

  public void setCostumer(Costumer costumer) {
    this.costumer = costumer;
  }
}
