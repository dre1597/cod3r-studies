public class BasicTypes {
  public static void main(String[] args) {
    byte years = 10;
    short flightNumbers = 500;
    int id = 5678110;
    long points = 311241412414L; // need to be explicit about the long type using a L or l on the final of the number
//    long pointsWithUnderline = 311_241_412_414L;

    float salary = 1000.00F; // need to be explicit about the float type using a F or f on the final of the number;
    double radius = 1241.11;

    boolean isOnline = false;

    char status = 'A';

    System.out.println("Days: " + years * 365);
    System.out.println("JustGoing : " + flightNumbers / 2);
    System.out.println("Bonus salary of the employee " + id + " : " + (salary * points) / 100);
    System.out.println("Area of a circle: " + radius * radius * 3.14);
    System.out.println("User is online: " + (isOnline ? "Yes" : "No"));
    System.out.println("Status of the user: " + status);
  }
}
