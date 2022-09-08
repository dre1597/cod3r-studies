import java.util.HashMap;
import java.util.Map;

public class MapCollection {
  public static void main(String[] args) {
    Map<Integer, String> map = new HashMap<>();

    map.put(1, "elem1");
    map.put(2, "elem2");
    map.put(2, "otherElem2");

    System.out.println(map.keySet());
    System.out.println(map.values());
    System.out.println(map.entrySet());

    System.out.println(map.containsKey(2));
    System.out.println(map.containsValue("elem1"));
    System.out.println(map.get(1));
    System.out.println(map.getOrDefault(5, "elem5"));

    for (int key : map.keySet()) {
      System.out.println(key);
    }

    for (String value : map.values()) {
      System.out.println(value);
    }

    for (Map.Entry<Integer, String> elem : map.entrySet()) {
      System.out.println(elem);
    }
  }
}
