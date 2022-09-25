package minesweeper.model;

@FunctionalInterface
public interface FieldObserver {
  void eventOccurred(Field field, FieldEvent fieldEvent);
}
