import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class BuildStreams {
  public static void main(String[] args) {
    Consumer<String> print = System.out::print;
    Consumer<Integer> printInt = System.out::print;

    Stream<String> langs = Stream.of("Java ", "Lua ", "Type Script\n");
    langs.forEach(print);

    String[] otherLangs = { "Python ", "Ruby ", "Pearl\n"};

    Stream.of(otherLangs).forEach(print);

    Arrays.stream(otherLangs).forEach(print);

    Arrays.stream(otherLangs, 1, 3).forEach(print);

    List<String> moreLangs = Arrays.asList("C ", "C++ ", "C#\n");
//    moreLangs.stream().forEach(print);
    moreLangs.forEach(print);

    moreLangs.parallelStream().forEach(print);

//    Stream.generate(() -> "a").forEach(print);

//    Stream.iterate(0, n -> n + 1).forEach(printInt);
  }
}
