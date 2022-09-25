package calculator.model;

@FunctionalInterface
public interface MemoryObserver {
  void valueChanged(String newValue);
}
