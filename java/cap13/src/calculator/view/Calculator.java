package calculator.view;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

  public Calculator() {

    organizeLayout();

    setSize(232, 322);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Calculator();
  }

  private void organizeLayout() {
    setLayout(new BorderLayout());


    Display display = new Display();
    display.setPreferredSize(new Dimension(233, 60));
    add(display, BorderLayout.NORTH);

    Keyboard keyboard = new Keyboard();
    add(keyboard, BorderLayout.CENTER);
  }
}
