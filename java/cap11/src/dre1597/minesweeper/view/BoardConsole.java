package dre1597.minesweeper.view;

import dre1597.minesweeper.exception.ExitException;
import dre1597.minesweeper.exception.ExplosionException;
import dre1597.minesweeper.model.Board;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class BoardConsole {
  private final Board board;
  private final Scanner scanner = new Scanner(System.in);

  public BoardConsole(Board board) {
    this.board = board;

    initGame();
  }

  private void initGame() {
    try {
      boolean wantToContinue = true;

      while (wantToContinue) {
        run();

        System.out.println("Play again? (Y/n) ");
        String answer = scanner.nextLine();

        if ("n".equalsIgnoreCase(answer)) {
          wantToContinue = false;
        } else {
          board.restart();
        }
      }
    } catch (ExitException exitException) {
      System.out.println("Bye!");
    } finally {
      scanner.close();
    }
  }

  private void run() {
    try {
      while (!board.goalCompleted()) {
        System.out.println(board);

        String value = getPromptValue("Type (x,y): ");

        // It's only work for numbers

        Iterator<Integer> xy = Arrays.stream(value.split(","))
            .map(e -> Integer.parseInt(e.trim())).iterator();

        value = getPromptValue("1 - Open or 2 - Toggle Mark: ");

        if ("1".equals(value)) {
          board.open(xy.next(), xy.next());
        } else if ("2".equals(value)) {
          board.toggleMark(xy.next(), xy.next());
        }
      }
      System.out.println(board);
      System.out.println("You win!");
    } catch (ExplosionException explosionException) {
      System.out.println(board);
      System.out.println("You lose!");
    }
  }

  private String getPromptValue(String text) {
    System.out.print(text);
    String value = scanner.nextLine();

    if ("quit".equalsIgnoreCase(value)) {
      throw new ExitException();
    }

    return value;
  }
}
