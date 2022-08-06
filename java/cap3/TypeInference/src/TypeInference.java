public class TypeInference {
  public static void main(String[] args) {
    var num = 12;
    System.out.println("Int: " + num);
//    num = "Text"; NOT POSSIBLE
    var text = "Text";
    System.out.println("Text: " + text);
//    text = 12; NOT POSSIBLE

//    var a; NOT POSSIBLE
//    a = 12;
  }
}
