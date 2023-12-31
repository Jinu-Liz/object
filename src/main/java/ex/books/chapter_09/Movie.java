package ex.books.chapter_09;


import ex.books.chapter_09.policy.DiscountPolicy;
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

  private DiscountPolicy discountPolicy;

  public Movie(String title, Duration runningTime, Money fee) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
  }

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
