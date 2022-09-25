package minesweeper.view;

import minesweeper.model.Board;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
  public BoardPanel(Board board) {
    setLayout(new GridLayout(board.getLines(), board.getColumns()));

    board.forEachField(field -> add(new FieldButton(field)));

    board.storeObserver(event -> SwingUtilities.invokeLater(() -> {
      if (event) {
        JOptionPane.showMessageDialog(this, "Win :)");
      } else {
        JOptionPane.showMessageDialog(this, "Lose :(");
      }

      board.restart();
    }));
  }
}
