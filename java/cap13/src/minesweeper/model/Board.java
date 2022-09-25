package minesweeper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Board implements FieldObserver {
  private final int lines;
  private final int columns;
  private final int mines;

  private final List<Field> fields = new ArrayList<>();
  private final List<Consumer<Boolean>> observers = new ArrayList<>();

  public Board(int lines, int columns, int mines) {
    this.lines = lines;
    this.columns = columns;
    this.mines = mines;

    generateFields();
    associateNeighbors();
    drawMines();
  }

  public void forEachField(Consumer<Field> consumer) {
    fields.forEach(consumer);
  }

  public int getLines() {
    return lines;
  }

  public int getColumns() {
    return columns;
  }

  public void storeObserver(Consumer<Boolean> observer) {
    observers.add(observer);
  }

  private void notifyObservers(boolean result) {
    observers.forEach(observer -> observer.accept(result));
  }

  private void generateFields() {
    for (int line = 0; line < lines; line++) {
      for (int column = 0; column < columns; column++) {
        Field field = new Field(line, column);
        field.storeObserver(this);
        fields.add(field);
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

  @Override
  public void eventOccurred(Field field, FieldEvent fieldEvents) {
    if (fieldEvents == FieldEvent.EXPLODE) {
      System.out.println("Loses");
      showMines();
      notifyObservers(false);
    } else if (goalCompleted()) {
      System.out.println("Wins");
      notifyObservers(true);
    }
  }

  private void showMines() {
    fields.stream()
        .filter(Field::isMined)
        .filter(field -> !field.isMarked())
        .forEach(Field::setOpened);
  }
}

