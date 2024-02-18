package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.time.Duration;

/**
 * TaxableRegularPhone과 대부분의 코드가 중복된다.
 * 대부분의 객체지향 언어의 경우, 단일 상속만 지원하기 때문에
 * 상속으로 인해 발생하는 중복 코드 문제를 해결하기 쉽지 않다.
 */
public class TaxableNightlyDiscountPhone extends NightlyDiscountPhone {

  private double taxRate;

  public TaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    super(nightlyAmount, regularAmount, seconds);
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
