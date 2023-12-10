package ex.books.chapter_08;


import ex.books.chapter_08.policy.DiscountPolicy;
import ex.books.common.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@AllArgsConstructor
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

  public Money calculateMovieFee(Screening screening) {

    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }

  public Money calculateMovieFee(Screening screening, DiscountPolicy discountPolicy) {

    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }
}
