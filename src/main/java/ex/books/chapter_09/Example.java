package ex.books.chapter_09;

import ex.books.chapter_09.policy.AmountDiscountPolicy;
import ex.books.common.Money;

import java.time.Duration;

public class Example {
  public static void main(String[] args) {

    /**
     * Locator 사용 시, ServiceLocator에 인스턴스를 등록 후 Movie를 생성하면 된다.
     * 그러나 Locator의 경우, 의존성을 감추기 때문에 퍼블릭 인터페이스 어디에도 이 의존성에 대한 정보가 없다.
     */
    ServiceLocator.provide(new AmountDiscountPolicy());
    Movie avatar = new Movie(
      "아바타",
      Duration.ofMinutes(120),
      Money.wons(10000)
    );

    /**
     *  해당 코드는 언뜻 보기에는 온전한 상태로 생성되는 것처럼 보이나,
     *  discountPolicy의 값이 null이기 때문에 NPE가 발생한다.
     *  이후, 디버깅을 통해 ServiceLocator를 이용하여 의존성을 해결해야한다는 사실을 깨닫고
     *  Locator을 추가하여 문제를 해결할 것이다.
     *  의존성을 구현 내부로 감출 경우, 컴파일타임이 아닌 런타임에 가서야 발견된다.
     *  문제 발견 시점을 코드 작성 시점이 아닌 실행 시점으로 미룸으로써 이해하기 어렵고 디버깅하기 어려워진다.
     *  또한 ServiceLocator은 내부적으로 정적 변수를 통해 객체들을 관리하기 대문에 모든 단위 테스트 케이스에 걸쳐
     *  ServiceLocator의 상태를 공유하므로 '단위 테스트는 서로 고립되어야 한다.'는 테스트의 기본 원칙을 위반한다.
     *  캡슐화란 단순히 변수의 가시성을 private으로 선언하여 변경 내용을 숨기는 것이 아니다.
     *  클래스 사용법을 익히기 위해 구현 내부를 뒤져야 한다면 캡슐화는 무너진 것이다.
     */
    Movie avatar2 = new Movie(
      "아바타",
      Duration.ofMinutes(120),
      Money.wons(10000)
    );

    avatar2.calculateMovieFee(new Screening());
  }
}
