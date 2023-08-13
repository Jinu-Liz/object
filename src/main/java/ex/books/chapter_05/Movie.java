package ex.books.chapter_05;

import ex.books.common.Money;

import java.time.Duration;
import java.util.List;

public class Movie {

  private String title;

  private Duration runningTime;

  private Money fee;

  private List<DiscountCondition> discountConditions;

  private MovieType movieType;

  private Money discountAmount;

  private double discountPercent;

  private List<PeriodCondition> periodConditions;

  private List<SequenceCondition> sequenceConditions;

  public Money calculateMovieFee(Screening screening) {
    if (isDiscountable(screening)) return fee.minus(calculateDiscountAmount());

    return fee;
  }

  private Money calculateDiscountAmount() {
    switch (movieType) {
      case AMOUNT_DISCOUNT -> calculateAmountDiscountAmount();
      case PERCENT_DISCOUNT -> calculatePercentDiscountAmount();
      case NONE_DISCOUNT -> calculateNoneDiscountAmount();
    }

    throw new IllegalArgumentException();
  }

  private boolean isDiscountable(Screening screening) {
    return checkPeriodConditions(screening) || checkSequenceConditions(screening);
  }

  private Money calculateAmountDiscountAmount() {
    return discountAmount;
  }

  private Money calculatePercentDiscountAmount() {
    return fee.times(discountPercent);
  }

  private Money calculateNoneDiscountAmount() {
    return Money.ZERO;
  }

  /**
   * conditions가 나눠지면서, Movie가 협력해야하는 클래스가 두 개로 나위어졌다. (DiscountCondition -> SequenceCondition, PeriodCondition)
   * 가장 쉽게 해당 문제를 해결하는 방법은 각 클래스들의 목록을 별도로 유지하는 것이다.
   */
  private boolean checkPeriodConditions(Screening screening) {
    return periodConditions.stream()
      .anyMatch(condition -> condition.isSatidfiedBy(screening));
  }

  private boolean checkSequenceConditions(Screening screening) {
    return sequenceConditions.stream()
      .anyMatch(condition -> condition.isSatisfiedBy(screening));
  }
}
