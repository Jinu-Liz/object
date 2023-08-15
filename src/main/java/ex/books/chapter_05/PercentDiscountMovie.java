package ex.books.chapter_05;

import ex.books.common.Money;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {

  private double percent;

  public PercentDiscountMovie(String title, Duration runningTime, Money fee, double percent, DCCondition... discountConditions) {
    super(title, runningTime, fee, discountConditions);
    this.percent = percent;
  }

  @Override
  protected Money calculateDiscountAmount() {
    return getFee().times(percent);
  }
}
