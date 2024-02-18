package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.time.Duration;

public class TaxableRegularPhone extends RegularPhone {

  private double taxRate;

  public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
    super(amount, seconds);
    this.taxRate = taxRate;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    Money fee = super.calculateCallFee(call);

    return fee.plus(fee.times(taxRate));
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRate));
  }
}
