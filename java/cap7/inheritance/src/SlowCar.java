public class SlowCar extends Car {
  SlowCar(int maxSpeed) {
    super(Math.min(maxSpeed, 200));
  }
}
