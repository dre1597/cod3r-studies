package observer;

import java.util.Date;

public class BirthdayPersonArrivalEvent {
  private final Date arrivesAt;

  public BirthdayPersonArrivalEvent(Date arrivesAt) {
    this.arrivesAt = arrivesAt;
  }

  public Date getArrivesAt() {
    return arrivesAt;
  }
}