package ex.books.chapter_13.before;

public class Client {
  public static void main(String[] args) {
    Penguin penguin = new Penguin();
    penguin.fly();
  }

  /**
   * 클라이언트가 날 수 있는 새만을 원한다고 가정해보자.
   * 현재 Penguin은 Bird의 자식 클래스이기 때문에 업캐스팅을 허용한다.
   * 따라서 flyBird 메서드의 인자로 Penguin의 인스턴스가 전달되는 것을 막을 수 있는 방법이 없다.
   * 그러나 Penguin은 날 수 없는 새이기 때문에 flyBird 메서드의 인자로 전달되어서는 안된다.
   * Penguin은 클라이언트의 기대를 저버리기 때문에 Bird의 서브타입이 아니다.
   * 따라서 이 둘을 상속 관계로 연결한 설계는 수정되어야 한다.
   */
  public void flyBird(Bird bird) {

    // 인자로 전달된 모든 bird는 날 수 있어야 한다.
    bird.fly();
  }
}
