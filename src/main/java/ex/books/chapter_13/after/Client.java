package ex.books.chapter_13.after;

import ex.books.chapter_13.before.Penguin;

public class Client {
  public static void main(String[] args) {
    Penguin penguin = new Penguin();
    penguin.fly();
  }

  /**
   * 이제 flyBird 메서드는 FlyingBird 타입을 이용하여
   * 날 수 있는 새만 인자로 전달되어야 한다는 사실을 코드에 명시할 수 있다.
   */
  public void flyBird(FlyingBird bird) {
    bird.fly();
  }
}
