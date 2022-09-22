package observer;

@FunctionalInterface
public interface BirthdayPersonArrivalObserver {
  void arrives(BirthdayPersonArrivalEvent event);
}
