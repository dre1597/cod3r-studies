package minesweeper.view;

import minesweeper.model.Field;
import minesweeper.model.FieldEvent;
import minesweeper.model.FieldObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FieldButton extends JButton implements FieldObserver, MouseListener {

  private final Color DEFAULT_BG = new Color(184, 184, 184);
  private final Color MARKED_BG = new Color(8, 179, 247);
  private final Color EXPLODED_BG = new Color(189, 66, 68);
  private final Color GREEN_TEXT = new Color(0, 100, 0);
  private final Field field;

  public FieldButton(Field field) {
    this.field = field;
    setBackground(DEFAULT_BG);
    setOpaque(true);
    setBorder(BorderFactory.createBevelBorder(0));

    addMouseListener(this);
    field.storeObserver(this);
  }

  @Override
  public void eventOccurred(Field field, FieldEvent fieldEvent) {
    switch (fieldEvent) {
      case OPEN -> applyStyleForOpenedField();
      case MARK -> applyStyleForMarkedField();
      case EXPLODE -> applyStyleForExplodedField();
      default -> applyDefaultStyle();
    }

    SwingUtilities.invokeLater(() -> {
      repaint();
      validate();
    });
  }

  private void applyStyleForOpenedField() {
    setBorder(BorderFactory.createLineBorder(Color.GRAY));

    if (field.isMined()) {
      setBackground(EXPLODED_BG);
      return;
    }

    setBackground(DEFAULT_BG);

    switch (field.neighborMines()) {
      case 1:
        setForeground(GREEN_TEXT);
        break;
      case 2:
        setForeground(Color.BLUE);
        break;
      case 3:
        setForeground(Color.YELLOW);
        break;
      case 4:
      case 5:
      case 6:
        setForeground(Color.RED);
      default:
        setForeground(Color.PINK);
        break;
    }

    String value = !field.isNeighborSecure() ? field.neighborMines() + "" : "";
    setText(value);
  }

  private void applyStyleForMarkedField() {
    setBackground(MARKED_BG);
    setForeground(Color.BLACK);
    setText("M");
  }

  private void applyStyleForExplodedField() {
    setBackground(EXPLODED_BG);
    setForeground(Color.WHITE);
    setText("X");
  }

  private void applyDefaultStyle() {
    setBackground(DEFAULT_BG);
    setBorder(BorderFactory.createBevelBorder(0));
    setText("");
  }

  @Override
  public void mousePressed(MouseEvent event) {
    if (event.getButton() == 1) {
      field.open();
    } else {
      field.toggleMark();
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }
}
