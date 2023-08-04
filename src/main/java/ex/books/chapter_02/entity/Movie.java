package ex.books.chapter_02.entity;

import ex.books.chapter_02.policy.DiscountPolicy;
import lombok.Data;

import java.time.Duration;

@Data
public class Movie {

  private String title;

  private Duration runningTime;

  private Money fee;

  private DiscountPolicy defaultDiscountPolicy;

  public Movie(String title, Duration runningTime, Money fee, DiscountPolicy defaultDiscountPolicy) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.defaultDiscountPolicy = defaultDiscountPolicy;
  }

  public Money calculateMovieFee(Screening screening) {
    /**
     * 할인 정책이 없는 경우 조건문을 사용하여 처리하게 되면
     * 할인 금액이 0원이라는 사실을 결정하는 책임이 DiscountPolicy가 아닌 Movie쪽에 있게 된다.
     * 따라서 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대체로 옳지 않은 선택이다.
     * 항상 예외 케이스를 최소화하고 일관성을 유지할 수 있는 방법을 선택해야한다.
     */
    return (defaultDiscountPolicy != null) ? fee.minus(defaultDiscountPolicy.calculateDiscountAmount(screening)) : fee;
  }
}
