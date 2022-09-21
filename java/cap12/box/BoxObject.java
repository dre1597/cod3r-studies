package box;

public class BoxObject {
  private Object thing;

  public void save(Object thing) {
    this.thing = thing;
  }

  public Object open() {
    return thing;
  }
}
