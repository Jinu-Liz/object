package ex.books.chapter_11.composite.phone.policy;

import ex.books.common.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {

  private Money discountAmount;

  public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
    super(next);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }
}
