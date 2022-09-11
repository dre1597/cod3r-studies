public class Car {
  final int MAX_SPEED;
  int currentSpeed;
  int factor = 5;

  Car(int maxSpeed) {
    MAX_SPEED = maxSpeed;
  }

  void speedUp() {
    if (this.currentSpeed + this.factor > this.currentSpeed) {
      this.currentSpeed = this.MAX_SPEED;
    } else {
      this.currentSpeed += this.factor;
    }
  }

  void brake() {
    if (this.currentSpeed >= 5) {
      this.currentSpeed -= 5;
    } else {
      this.currentSpeed = 0;
    }
  }
}
