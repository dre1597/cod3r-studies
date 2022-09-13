package exceptions.customExceptionB;

public class EmptyStringException extends Exception {

  private final String attributeName;

  public EmptyStringException(String attributeName) {
    this.attributeName = attributeName;
  }

  @Override
  public String getMessage() {
    return String.format("The attribute %s is empty", this.attributeName);
  }
}
