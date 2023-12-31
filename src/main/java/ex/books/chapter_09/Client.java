package ex.books.chapter_09;

import ex.books.common.Money;
import lombok.AllArgsConstructor;

/**
 * 기존 Client의 코드 (이전 챕터의 Example)를 보면 Movie의 인스턴스를 생성하는 동시에
 * getFee 메시지도 함께 전송하고 있다. 즉, 생성과 사용의 책임을 함께 지니고 있다.
 * 이를 Factory에 생성 책임을 이전하여, 책임을 분리하여 사용할 수 있다.
 * (생성: Factory, 사용: Client)
 */
@AllArgsConstructor
public class Client {

  private Factory factory;

  public Money getAvatarFee() {
    Movie avatar = factory.createAvatarMovie();
    return avatar.getFee();
  }
}
