package app.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
  public static void info(String message) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    System.out.println("[INFO] " + simpleDateFormat.format(new Date()) + " - " + message);
  }
}
