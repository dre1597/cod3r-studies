package box;

public class Box<T> {
  private T thing;

  public void save(T thing) {
    this.thing = thing;
  }

  public T open() {
    return thing;
  }
}
