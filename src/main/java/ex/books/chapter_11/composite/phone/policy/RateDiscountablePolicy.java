package ex.books.chapter_11.composite.phone.policy;

import ex.books.common.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {

  private Money discountAmount;

  public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
    super(next);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }
}
