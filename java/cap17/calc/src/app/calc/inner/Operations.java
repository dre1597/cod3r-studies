package app.calc.inner;

import java.util.Arrays;

public class Operations {
  public double sum(double... nums) {
    return Arrays.stream(nums).reduce(0.0, Double::sum);
  }
}
