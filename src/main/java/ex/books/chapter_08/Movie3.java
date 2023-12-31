package ex.books.chapter_08;


import ex.books.chapter_08.policy.DiscountPolicy;
import ex.books.common.Money;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@NoArgsConstructor
@Data
public class Movie3 {

  private String title;

  private Duration runningTime;

  private Money fee;

  private DiscountPolicy discountPolicy;

  public Movie3(String title, Duration runningTime, Money fee) {
    this(title, runningTime, fee, null
    );
  }

  public Movie3(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountPolicy = discountPolicy;
  }

  /**
   * 할인 혜택이 없는 영화의 경우, 할인 정책을 담당하는 DiscountPolicy에 어떤 객체도 할당하지 않도록 할 수 있다.
   * 이 경우, 생성자에서 null값을 할당하고 null이 존재하는지 판단한다.
   * 이 코드는 한 가지 문제가 있는데, 지금까지의 방식에서 어긋나는 예외 케이스가 추가된 것이다.
   * 이를 처리하기 위해서는 Movie의 내부 코드를 직접 수정해야 한다.
   * 이는 버그 발생 가능성을 높인다.
   */
  public Money calculateMovieFee(Screening screening) {
    if (this.discountPolicy == null) {
      return this.fee;
    }

    return this.fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }

  public Money calculateMovieFee(Screening screening, DiscountPolicy discountPolicy) {
    return discountPolicy.calculateDiscountAmount(screening);
  }
}
