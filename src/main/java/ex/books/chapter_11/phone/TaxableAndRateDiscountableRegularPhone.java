package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.time.Duration;

/**
 * 세금이 부과된 요금 계산 후, 기본 요금 할인 정책을 적용한 일반 요금제
 */
public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {

  private Money discountAmount;

  public TaxableAndRateDiscountableRegularPhone(Money nightlyAmount, Duration seconds, double taxRate, Money discountAmount) {
    super(nightlyAmount, seconds, taxRate);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return super.afterCalculated(fee).minus(this.discountAmount);
  }
}
