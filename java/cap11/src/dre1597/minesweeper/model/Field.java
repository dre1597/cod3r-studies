package dre1597.minesweeper.model;

import dre1597.minesweeper.exception.ExplosionException;

import java.util.ArrayList;
import java.util.List;

public class Field {
  private final int line;
  private final int column;

  private boolean opened = false;
  private boolean mined = false;
  private boolean marked = false;

  private final List<Field> neighbors = new ArrayList<>();

  Field(int line, int column) {
    this.line = line;
    this.column = column;
  }

  public boolean isMarked() {
    return marked;
  }

  public boolean isOpened() {
    return opened;
  }

  void setOpened() {
    this.opened = true;
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
  }

  boolean open() {
    if (!opened && !marked) {
      opened = true;

      if (mined) {
        throw new ExplosionException();
      }

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

  public String toString() {
    if (marked) {
      return "x";
    } else if (opened && mined) {
      return "*";
    } else if (opened && neighborMines() > 0) {
      return Long.toString(neighborMines());
    } else if (opened) {
      return " ";
    } else {
      return "?";
    }
  }
}
