package ex.books.chapter_13;

public class Penguin2 extends Bird {

  /**
   * 두 번째 방법은 예외를 던지는 것이다.
   * 이 경우 Client의 flyBird 메서드에 전달되는 인자의 타입에 따라 메서드가 실패/성공하게 된다.
   * 그러나 flyBird 메서드는 모든 bird가 날 수 있다고 가정하고 있기 때문에 예외가 던져질 것이라고는
   * 기대하지 않았을 것이다.
   * 따라서 이 방법 역시 행동이 호환되지 않는다.
   */
  @Override
  public void fly() {
    throw new UnsupportedOperationException();
  }
}
