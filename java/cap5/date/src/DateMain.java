public class DateMain {
  public static void main(String[] args) {
    Date d1 = new Date();
    Date d2 = new Date(12, 31, 2022);

    String formattedDate1 = d1.getFormattedDate();
    String formattedDate2 = d2.getFormattedDate();

    System.out.println(formattedDate1);
    System.out.println(formattedDate2);
  }
}
