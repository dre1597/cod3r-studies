package minesweeper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Board {
  private final int lines;
  private final int columns;
  private final int mines;

  private final List<Field> fields = new ArrayList<>();


  public Board(int lines, int columns, int mines) {
    this.lines = lines;
    this.columns = columns;
    this.mines = mines;

    generateFields();
    associateNeighbors();
    drawMines();
  }

  public void open(int line, int column) {
    try {
      fields.parallelStream().filter(field -> field.getLine() == line && field.getColumn() == column).findFirst().ifPresent(Field::open);
    } catch (Exception exception) {
      // FIXME adjust implementation of open method
      fields.forEach(field -> field.setOpened(true));
      throw exception;
    }
  }

  public void toggleMark(int line, int column) {
    fields.parallelStream().filter(field -> field.getLine() == line && field.getColumn() == column).findFirst().ifPresent(Field::toggleMark);
  }

  private void generateFields() {
    for (int line = 0; line < lines; line++) {
      for (int column = 0; column < columns; column++) {
        fields.add(new Field(line, column));
      }
    }
  }

  private void associateNeighbors() {
    for (Field f1 : fields) {
      for (Field f2 : fields) {
        f1.addNeighbor(f2);
      }
    }
  }

  private void drawMines() {
    long minesAlreadyInField;

    Predicate<Field> mined = Field::isMined;

    do {
      int random = (int) (Math.random() * fields.size());
      fields.get(random).addMine();
      minesAlreadyInField = fields.stream().filter(mined).count();
    } while (minesAlreadyInField < mines);
  }

  public boolean goalCompleted() {
    return fields.stream().allMatch(Field::goalCompleted);
  }

  public void restart() {
    fields.forEach(Field::restart);
    drawMines();
  }
}

