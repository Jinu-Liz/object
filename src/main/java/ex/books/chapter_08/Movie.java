package ex.books.chapter_08;


import ex.books.chapter_08.policy.DiscountPolicy;
import ex.books.common.Money;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@NoArgsConstructor
@Data
public class Movie {

  private String title;

  private Duration runningTime;

  private Money fee;

  /**
   * Movie 클래스는 오직 추상 클래스인 DiscountPolicy 클래스에만 의존한다.
   * 따라서 구현체로의 의존성은 보이지 않지만, 런타임 의존성을 보면
   * 금액 할인 정책을 위해서는 AmountDiscountPolicy 인스턴스와 협력하고,
   * 비율 할인 정책을 적용하기 위해서는 PercentDiscountPolicy 인스턴스와 협력한다.
   *
   * 어느 한 곳에만 의존성을 가지만 다른 기능이 동작하지 않고, 둘 모두에 의존하도록하면
   * 전체적인 결합도를 높이고 새로운 할인 정책을 추가하는 등의 확장에 어려움이 생긴다.
   *
   * 현재의 구조처럼 DiscountPolicy라는 추상 클래스에 의존하도록 하고, 컴파일타임 의존성을 실행 시에
   * PercentDiscountPolicy 인스턴스나 AmountDiscountPolicy 인스턴스에 대한 런타임 의존성으로 대체해야 한다.
   * 즉, 컴파일타임 구조와 런타임 구조 사이의 거리가 멀면 멀수록 설계가 유연해지고 재사용 가능해진다.
   *
   */
  private DiscountPolicy discountPolicy;

  public Movie(String title, Duration runningTime, Money fee) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
  }

  /**
   * 생성자의 DiscountPolicy 인자가 추상 클래스 타입으로 선언됐기 때문에 객체를 생성할 때, 자식 클래스 중 어떤 것이라도 전달할 수 있다.
   * 따라서 런타임에 AmountDiscountPolicy 또는 PercentDiscountPolicy의 인스턴스를 선택적으로 전달할 수 있다.
   * 이는 수정자 주입 방식과 필드 주입 방식의 경우에도 동일하며, 모든 경우에 의존성은 명시적으로 퍼블릭 인터페이스에 노출된다.
   * 이를 명시적인 의존성(explicit dependency)이라고 부른다.
   *
   * 반면, Movie의 내부에서 AmountDiscountPolicy의 인스턴스를 직접 생성하는 방식은 Movie가 DiscountPolicy에 의존한다는 사실을 감춘다.
   * 즉, 의존성이 퍼블릭 인터페이스에 표현되지 않으며 이를 숨겨진 의존성(hidden dependency)이라고 부른다.
   *
   * 의존성이 명시적이지 않으면 의존성을 파악하기 위해 내부 구현을 직접 살펴보아야한다.
   * 이를 파악하는 것은 쉽지 않을 뿐더러, 클래스를 다른 컨텍스트에서 재사용하기 위하여 내부 구현을 직접 변경해야 한다는 것이다.
   * 이는 또다른 버그 발생 가능성을 내포한다.
   *
   * 따라서 의존성을 퍼블릭 인터페이스를 통해 명시적으로 드러내야하며,
   * 그래야 퍼블릭 인터페이스를 통해 컴파일타임 의존성을 적절한 런타임 의존성으로 교체할 수 있다.
   */
  public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountPolicy = discountPolicy;
  }

  public Money calculateMovieFee(Screening screening) {

    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }

  public Money calculateMovieFee(Screening screening, DiscountPolicy discountPolicy) {

    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }
}
