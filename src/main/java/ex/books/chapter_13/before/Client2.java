package ex.books.chapter_13.before;

public class Client2 {
  public static void main(String[] args) {
    Penguin penguin = new Penguin();
    penguin.fly();
  }

  /**
   * 세 번째 방법은 bird의 타입이 Penguin이 아닐 경우에만 fly 메시지를 전송하도록 하는 것이다.
   * 그러나 Penguin 이외에 날 수 없는 또 다른 새가 추가되면 새로운 타입을 체크하는 코드를 추가해야한다.
   * 이는 new 연산자와 마찬가지로 구체적인 클래스에 대한 결합도를 높인다.
   * 일반적으로 instanceof처럼 객체의 타입을 확인하는 코드는 새로운 타입을 추가할 때마다 코드 수정을 요구하기 때문에
   * 개방-폐쇄 원칙을 위반한다.
   */
  public void flyBird(Bird bird) {
    if (!(bird instanceof Penguin)) {
      bird.fly();
    }
  }
}
