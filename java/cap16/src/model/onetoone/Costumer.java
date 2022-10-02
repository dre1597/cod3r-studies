package model.onetoone;

import javax.persistence.*;

@Entity
public class Costumer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "seat_id", unique = true)
  private Seat seat;

  public Costumer() {

  }

  public Costumer(String name, Seat seat) {
    this.name = name;
    this.seat = seat;
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

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }
}
