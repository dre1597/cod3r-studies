public class Car {
  final Engine engine = new Engine();
  private final double factor = 0.4;

  void turnOn() {
    this.engine.on = true;
  }

  void turnOff() {
    this.engine.on = false;
  }

  boolean isOn() {
    return this.engine.on;
  }

  void brake() {
    this.engine.injectionFactor -= this.factor;
  }

  void speedUp() {
    this.engine.injectionFactor += this.factor;
  }
}
