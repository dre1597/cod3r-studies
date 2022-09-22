package observer;

public class BirthdayMain {
  public static void main(String[] args) {
    Girlfriend girlfriend = new Girlfriend();
    Doorman doorman = new Doorman();

    doorman.storeObserver(girlfriend);

    doorman.storeObserver(event -> System.out.println("Using lambda" + event.getArrivesAt()));
    doorman.monitor();
  }
}
