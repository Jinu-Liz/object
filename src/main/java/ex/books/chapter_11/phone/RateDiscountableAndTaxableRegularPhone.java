package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.time.Duration;

/**
 * 기본 요금 할인 정책을 적용 후, 세금을 부과한 일반 요금제
 */
public class RateDiscountableAndTaxableRegularPhone extends RateDiscountableRegularPhone {

  private double taxRate;

  public RateDiscountableAndTaxableRegularPhone(Money amount, Duration seconds, Money discountAmount, double taxRate) {
    super(amount, seconds, discountAmount);
    this.taxRate = taxRate;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return super.afterCalculated(fee).plus(fee.times(taxRate));
  }
}
