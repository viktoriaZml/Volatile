public class Box {
  private volatile boolean flag = false;
  private final int numberOfIter = 10;
  private final int pauseTime = 2000;

  public void turnOff() {
    while (true) {
      if (Thread.currentThread().isInterrupted()) return;
      if (flag) {
        flag = false;
        System.out.println(Thread.currentThread().getName() + ": Выключить");
      }
    }
  }

  public void turnOn() {
    int iter = 0;
    while (iter < numberOfIter) {
      try {
        Thread.sleep(pauseTime);
      } catch (InterruptedException e) {
        break;
      }
      System.out.println(Thread.currentThread().getName() + ": Включить");
      flag = true;
      iter++;
    }
  }
}
