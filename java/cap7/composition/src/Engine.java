public class Engine {
  double injectionFactor = 1;
  boolean on = false;

  int getCurrentRotation() {
    if (!on) {
      return 0;
    }

    return (int) Math.round(injectionFactor * 3000);
  }
}
