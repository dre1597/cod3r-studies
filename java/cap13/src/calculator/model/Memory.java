package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {

  private static final Memory instance = new Memory();
  private final List<MemoryObserver> observers = new ArrayList<>();
  private String currentText = "";
  private String bufferText = "";
  private Boolean substitute = false;
  private CommandType lastOperation = null;

  private Memory() {
  }

  public static Memory getInstance() {
    return instance;
  }

  public void storeObserver(MemoryObserver observer) {
    observers.add(observer);
  }

  public String getCurrentText() {
    return currentText.isEmpty() ? "0" : currentText;
  }

  public void processCommand(String text) {
    CommandType commandType = detectCommandType(text);

    if (commandType == null) {
      return;
    } else if (commandType == CommandType.CLEAR) {
      currentText = "";
      bufferText = "";
      substitute = false;
      lastOperation = null;
    } else if (commandType == CommandType.NUMBER || commandType == CommandType.COMMA) {
      currentText = substitute ? text : currentText + text;
      substitute = false;
    } else {
      substitute = true;
      currentText = getOperationResult();
      bufferText = currentText;
      lastOperation = commandType;
    }

    observers.forEach(observer -> observer.valueChanged(getCurrentText()));
  }

  private String getOperationResult() {
    if (lastOperation == null || lastOperation == CommandType.EQUAL) {
      return currentText;
    }

    double bufferNumber = Double.parseDouble(bufferText.replace(',', '.'));
    double currentNumber = Double.parseDouble(currentText.replace(',', '.'));

    double result = 0;

    if (lastOperation == CommandType.SUM) {
      result = bufferNumber + currentNumber;
    } else if (lastOperation == CommandType.SUBTRACTION) {
      result = bufferNumber - currentNumber;
    } else if (lastOperation == CommandType.MULTIPLICATION) {
      result = bufferNumber * currentNumber;
    } else if (lastOperation == CommandType.DIVISION) {
      result = bufferNumber / currentNumber;
    }

    String resultString = Double.toString(result).replace('.', ',');
    boolean integer = resultString.endsWith(",0");
    return integer ? resultString.replace(",0", "") : resultString;
  }

  private CommandType detectCommandType(String text) {
    if (currentText.isEmpty() && text.equals("0")) {
      return null;
    }

    try {
      Integer.parseInt(text);
      return CommandType.NUMBER;
    } catch (Exception error) {
      if ("AC".equals(text)) {
        return CommandType.CLEAR;
      } else if ("/".equals(text)) {
        return CommandType.DIVISION;
      } else if ("*".equals(text)) {
        return CommandType.MULTIPLICATION;
      } else if ("-".equals(text)) {
        return CommandType.SUBTRACTION;
      } else if ("+".equals(text)) {
        return CommandType.SUM;
      } else if ("=".equals(text)) {
        return CommandType.EQUAL;
      } else if (",".equals(text) && !currentText.contains(",")) {
        return CommandType.COMMA;
      }
    }
    return null;
  }

  private enum CommandType {
    CLEAR, NUMBER, DIVISION, MULTIPLICATION, SUBTRACTION, SUM, EQUAL, COMMA
  }
}
