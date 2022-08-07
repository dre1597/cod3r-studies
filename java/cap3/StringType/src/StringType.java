public class StringType {
  public static void main(String[] args) {
    String helloWorld = "Hello World";

    System.out.println(helloWorld.charAt(0));
    System.out.println(helloWorld.concat("!"));
    System.out.println(helloWorld.startsWith("Hello"));
    System.out.println(helloWorld.toLowerCase().startsWith("Hello"));
    System.out.println(helloWorld.toLowerCase().endsWith("World"));
    System.out.println(helloWorld.length());
    System.out.println(helloWorld.equals("Hello World"));
    System.out.println(helloWorld.equalsIgnoreCase("hello world"));

    System.out.printf("%s", helloWorld);
    // .format will be the same thing that went inside the print, but now it's possible to send it to a variable
    String phrase = String.format("%s", helloWorld);
    System.out.println(phrase);
  }
}
