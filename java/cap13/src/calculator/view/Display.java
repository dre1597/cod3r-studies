package calculator.view;

import calculator.model.Memory;
import calculator.model.MemoryObserver;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements MemoryObserver {

  private final JLabel label = new JLabel(Memory.getInstance().getCurrentText());

  public Display() {
    Memory.getInstance().storeObserver(this);

    setBackground(new Color(46, 49, 50));
    label.setForeground(Color.WHITE);
    label.setFont(new Font("courier", Font.PLAIN, 30));
    setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
    add(label);
  }

  @Override
  public void valueChanged(String newValue) {
    label.setText(newValue);
  }
}
