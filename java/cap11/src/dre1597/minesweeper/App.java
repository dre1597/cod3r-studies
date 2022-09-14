package dre1597.minesweeper;

import dre1597.minesweeper.model.Board;
import dre1597.minesweeper.view.BoardConsole;

public class App {
  public static void main(String[] args) {
    Board board = new Board(4, 4, 2);
    new BoardConsole(board);
  }
}
