package ex.books.chapter_05;

import ex.books.common.Money;

import java.time.Duration;

public class AmountDiscountMovie extends Movie {

  private Money discountAmount;

  public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount, DCCondition... discountConditions) {
    super(title, runningTime, fee, discountConditions);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money calculateDiscountAmount() {
    return this.discountAmount;
  }

}
