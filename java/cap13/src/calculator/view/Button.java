package calculator.view;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
  public Button(String text, Color color) {
    setText(text);
    setOpaque(true);
    setBackground(color);
    setForeground(Color.WHITE);
    setFont(new Font("courier", Font.PLAIN, 25));
    setBorder(BorderFactory.createLineBorder(Color.black));
  }
}
