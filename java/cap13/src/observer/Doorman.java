package observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Doorman {
  private List<BirthdayPersonArrivalObserver> observers = new ArrayList<>();

  public void storeObserver(BirthdayPersonArrivalObserver observer) {
    observers.add(observer);
  }

  public void monitor() {
    Scanner scanner = new Scanner(System.in);

    String value = "";

    while (!"exit".equalsIgnoreCase(value)) {
      System.out.println("Arrives? ");
      value = scanner.nextLine();

      if ("yes".equalsIgnoreCase(value)) {
        BirthdayPersonArrivalEvent event = new BirthdayPersonArrivalEvent(new Date());
        observers.forEach(observer -> observer.arrives(event));
        value = "exit";
      } else {
        System.out.println("Not him");
      }
    }

    scanner.close();
  }
}
