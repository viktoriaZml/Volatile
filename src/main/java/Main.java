public class Main {
  public static void main(String[] args) throws InterruptedException {
    final Box box = new Box();
    Thread thread1 = new Thread(null, box::turnOn, "Пользователь");
    thread1.start();

    Thread thread2 = new Thread(null, box::turnOff, "Игрушка");
    thread2.start();

    thread1.join();
    thread2.interrupt();
  }
}
