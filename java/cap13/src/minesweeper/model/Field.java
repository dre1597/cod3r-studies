package minesweeper.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
  private final int line;
  private final int column;
  private final List<Field> neighbors = new ArrayList<>();
  private boolean opened = false;
  private boolean mined = false;
  private boolean marked = false;

  // could be a set here
  private List<FieldObserver> observers = new ArrayList<>();
  // private List<BiConsumer<Field, FieldEvent>>  observers = new ArrayList<>();

  Field(int line, int column) {
    this.line = line;
    this.column = column;
  }

  public void storeObserver(FieldObserver observer) {
    observers.add(observer);
  }

  private void notifyObservers(FieldEvent event) {
    observers.forEach(observer -> observer.eventOccurred(this, event));
  }

  public boolean isMarked() {
    return marked;
  }

  public boolean isOpened() {
    return opened;
  }

  void setOpened(boolean open) {
    this.opened = open;

    if (open) {
      notifyObservers(FieldEvent.OPEN);
    }
  }

  public boolean isClosed() {
    return !isOpened();
  }

  public boolean isMined() {
    return mined;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }

  boolean addNeighbor(Field neighbor) {
    boolean differentLine = line != neighbor.line;
    boolean differentColumn = column != neighbor.column;
    boolean isDiagonal = differentLine && differentColumn;

    int deltaLine = Math.abs(line - neighbor.line);
    int deltaColumn = Math.abs(column - neighbor.column);
    int delta = deltaLine + deltaColumn;

    if (!isDiagonal && delta == 1 || isDiagonal && delta == 2) {
      neighbors.add(neighbor);
      return true;
    }
    return false;
  }

  void toggleMark() {
    marked = !marked;

    if (marked) {
      notifyObservers(FieldEvent.MARK);
    } else {
      notifyObservers(FieldEvent.UNMARK);
    }
  }

  boolean open() {
    if (!opened && !marked) {
      if (mined) {
        notifyObservers(FieldEvent.EXPLODE);
        return true;
      }

      setOpened(true);

      notifyObservers(FieldEvent.OPEN);

      if (isNeighborSecure()) {
        neighbors.forEach(Field::open);
      }

      return true;
    }

    return false;
  }

  boolean isNeighborSecure() {
    return neighbors.stream().noneMatch(neighbor -> neighbor.mined);
  }

  void addMine() {
    mined = true;
  }

  boolean goalCompleted() {
    boolean clearField = !mined && opened;
    boolean minedField = mined && marked;

    return clearField || minedField;
  }

  long neighborMines() {
    return neighbors.stream().filter(neighbor -> neighbor.mined).count();
  }

  void restart() {
    opened = false;
    mined = false;
    marked = false;
  }
}
