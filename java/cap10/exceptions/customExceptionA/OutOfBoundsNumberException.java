package exceptions.customExceptionA;

public class OutOfBoundsNumberException extends RuntimeException {
  private final String attributeName;

  public OutOfBoundsNumberException(String attributeName) {
    this.attributeName = attributeName;
  }

  @Override
  public String getMessage() {
    return String.format("The attribute %s is out of bounds", this.attributeName);
  }
}
