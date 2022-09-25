package minesweeper.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
  private final int line;
  private final int column;
  private final List<Field> neighbors = new ArrayList<>();
  // could be a set here
  private final List<FieldObserver> observers = new ArrayList<>();
  private boolean opened = false;
  private boolean mined = false;
  private boolean marked = false;
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

  void setOpened() {
    this.opened = true;
    notifyObservers(FieldEvent.OPEN);
  }

  public boolean isMined() {
    return mined;
  }

  void addNeighbor(Field neighbor) {
    boolean differentLine = line != neighbor.line;
    boolean differentColumn = column != neighbor.column;
    boolean isDiagonal = differentLine && differentColumn;

    int deltaLine = Math.abs(line - neighbor.line);
    int deltaColumn = Math.abs(column - neighbor.column);
    int delta = deltaLine + deltaColumn;

    if (!isDiagonal && delta == 1 || isDiagonal && delta == 2) {
      neighbors.add(neighbor);
    }
  }

  public void toggleMark() {
    marked = !marked;

    if (marked) {
      notifyObservers(FieldEvent.MARK);
    } else {
      notifyObservers(FieldEvent.UNMARK);
    }
  }

  public void open() {
    if (!opened && !marked) {
      if (mined) {
        notifyObservers(FieldEvent.EXPLODE);
        return;
      }

      setOpened();

      notifyObservers(FieldEvent.OPEN);

      if (isNeighborSecure()) {
        neighbors.forEach(Field::open);
      }
    }
  }

  public boolean isNeighborSecure() {
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

  public int neighborMines() {
    return (int) neighbors.stream().filter(neighbor -> neighbor.mined).count();
  }

  void restart() {
    opened = false;
    mined = false;
    marked = false;

    notifyObservers(FieldEvent.RESTART);
  }
}
