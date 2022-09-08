public class Date {
  private final int MONTH;
  private final int DAY;
  private final int YEAR;

  Date() {
    this(1, 1, 1970);
  }

  Date(int month, int day, int year) {
    this.MONTH = month;
    this.DAY = day;
    this.YEAR = year;
  }

  String getFormattedDate() {
    return String.format("%d/%d/%d", this.MONTH, this.DAY, this.YEAR);
  }
}
