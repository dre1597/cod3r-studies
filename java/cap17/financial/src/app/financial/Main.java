package app.financial;

import app.calc.Calc;

public class Main {
  public static void main(String[] args) {
    Calc calc = new Calc();

    System.out.println(calc.sum(2,3,4,5));
  }
}