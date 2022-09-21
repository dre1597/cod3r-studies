package listUtil;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ListUtil {
  public static Object getLastV1(@NotNull List<?> list) {
    return list.get(list.size() - 1);
  }

  public static <T> T getLastV2(@NotNull List<T> list) {
    return list.get(list.size() - 1);
  }
}
