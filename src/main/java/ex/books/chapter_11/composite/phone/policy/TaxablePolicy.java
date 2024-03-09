package ex.books.chapter_11.composite.phone.policy;

import ex.books.common.Money;

public class TaxablePolicy extends AdditionalRatePolicy {

  private double taxRatio;

  public TaxablePolicy(RatePolicy next, double taxRatio) {
    super(next);
    this.taxRatio = taxRatio;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(this.taxRatio));
  }
}
