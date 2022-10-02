package app.calc;

import app.calc.inner.Operations;
import app.logging.Logger;

public class Calc {
  private Operations operations = new Operations();

  public double sum(double... nums) {
    Logger.info("Sum...");
    return operations.sum(nums);
  }
}
