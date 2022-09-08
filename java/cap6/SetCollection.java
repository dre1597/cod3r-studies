import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetCollection {
  public static void main(String[] args) {
    Set<Integer> hashSet = new HashSet<>();
    SortedSet<Integer> treeSet = new TreeSet<>();

    hashSet.add(1);
    hashSet.add(2);

    treeSet.add(4);
    treeSet.add(3);

    for (int elem : hashSet) {
      System.out.println(elem);
    }

    for (int elem : treeSet) {
      System.out.println(elem);
    }
  }
}
