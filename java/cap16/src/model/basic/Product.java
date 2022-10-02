package model.basic;

import javax.persistence.*;

@Entity
@Table
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 200, nullable = false)
  private String name;
  @Column(nullable = false, precision = 11, scale = 2)
  private Double price;

  public Product() {
  }

  public Product(String name, Double price) {
    this.name = name;
    this.price = price;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return this.getId() + " => "
        + this.getName() + " : "
        + this.getPrice();
  }
}
