package dre1597.minesweeper.model;

import dre1597.minesweeper.exception.ExplosionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {
  private Field field;

  @BeforeEach
  void initField() {
    field = new Field(3, 3);
  }

  @Test
  void isValidAdjacentNeighbor() {
    Field neighbor = new Field(3, 2);

    boolean result = field.addNeighbor(neighbor);

    assertTrue(result);
  }

  @Test
  void isValidNeighborOnDiagonal() {
    Field neighbor = new Field(2, 2);

    boolean result = field.addNeighbor(neighbor);

    assertTrue(result);
  }

  @Test
  void isInvalidNeighborOnLeft() {
    Field neighbor = new Field(3, 1);

    boolean result = field.addNeighbor(neighbor);

    assertFalse(result);
  }

  @Test
  void isInvalidNeighborOnDiagonal() {
    Field neighbor = new Field(1, 1);

    boolean result = field.addNeighbor(neighbor);

    assertFalse(result);
  }

  @Test
  void attributeMarkedHasCorrectDefaultValue() {
    assertFalse(field.isMarked());
  }

  @Test
  void toggleMarkShouldWorkCorrectly() {
    field.toggleMark();
    assertTrue(field.isMarked());

    field.toggleMark();
    assertFalse(field.isMarked());
  }

  @Test
  void shouldOpenDefaultField() {
    assertTrue(field.open());
  }

  @Test
  void shouldNotOpenMarkedField() {
    field.toggleMark();

    assertFalse(field.open());
  }

  @Test
  void shouldNotOpenMarkedMinedField() {
    field.toggleMark();
    field.addMine();

    assertFalse(field.open());
  }

  @Test
  void shouldThrowsMinedNotMarkedField() {
    field.addMine();

    assertThrows(ExplosionException.class, () -> field.open());
  }

  @Test
  void shouldOpenWithSecureNeighbors() {
    Field neighbor = new Field(2, 2);
    Field neighborFromNeighbor = new Field(1, 1);

    field.addNeighbor(neighbor);
    neighbor.addNeighbor(neighborFromNeighbor);

    field.open();

    assertTrue(neighbor.isOpened() && neighborFromNeighbor.isOpened());
  }

  @Test
  void shouldNotOpenWithNonSecureNeighbors() {
    Field neighbor = new Field(2, 2);
    Field neighborFromNeighbor = new Field(1, 1);

    neighborFromNeighbor.addMine();

    field.addNeighbor(neighbor);
    neighbor.addNeighbor(neighborFromNeighbor);

    field.open();

    assertTrue(neighbor.isOpened() && neighborFromNeighbor.isClosed());
  }
}
