package listUtil;

import java.util.Arrays;
import java.util.List;

public class ListUtilMain {
  public static void main(String[] args) {
    List<String> strings = Arrays.asList("elem1", "elem2", "elem3");
    List<Integer> numbers = Arrays.asList(1,2,3);

    String lastString1 = (String) ListUtil.getLastV1(strings);
    System.out.println(lastString1);

    Integer lastNumber1 = (Integer) ListUtil.getLastV1(numbers);
    System.out.println(lastNumber1);

    String lastString2 = ListUtil.getLastV2(strings);
    System.out.println(lastString2);

    Integer lastNumber2 =  ListUtil.<Integer>getLastV2(numbers);
    System.out.println(lastNumber2);
  }
}
