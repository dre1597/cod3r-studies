public class Wrapper {
  public static void main(String[] args) {
    Byte b = 100;
    Short s = 1000;
    Integer i = 10000;
    Long l = 100000L;
    Boolean bo = Boolean.parseBoolean("true");
    Character c = '#';
    Float f = 123.10F;
    Double d = 123.10;

    System.out.println(b.byteValue());
    System.out.println(s.shortValue());
    System.out.println(i.intValue());
    System.out.println(l.longValue());
    System.out.println(c.charValue());
    System.out.println(bo.toString().toUpperCase());
  }
}
