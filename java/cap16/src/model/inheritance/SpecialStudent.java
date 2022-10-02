package model.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SS")
public class SpecialStudent extends Student {

  private double value;

  public SpecialStudent() {

  }

  public SpecialStudent(Long code, String name, double value) {
    super(code, name);
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }
}
