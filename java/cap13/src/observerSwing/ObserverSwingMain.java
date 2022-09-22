package observerSwing;

import javax.swing.*;
import java.awt.*;

public class ObserverSwingMain {
  public static void main(String[] args) {
    JFrame window = new JFrame("Observer");
    window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    window.setSize(600, 400);
    window.setLayout(new FlowLayout());
    window.setLocationRelativeTo(null);

    JButton button = new JButton("Click!");
    window.add(button);
    button.addActionListener(event -> System.out.println("Clicked"));

    window.setVisible(true);
  }
}
