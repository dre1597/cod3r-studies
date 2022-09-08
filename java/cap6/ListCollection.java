import java.util.ArrayList;

public class ListCollection {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();

    list.add("elem1");
    list.add("elem2");
    list.add("elem3");
    list.add("elem4");

    System.out.println(list.get(0));

    list.remove(1);

    list.remove("elem4");

    System.out.println(list);

    System.out.println(list.contains("elem2"));
    System.out.println(list.contains("elem3"));
  }
}
