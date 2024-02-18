package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.time.Duration;

/**
 * 심야 요금제와 기본 요금 할인 정책을 조합한 클래스.
 */
public class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone {

  private Money discountAmount;

  public RateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount) {
    super(nightlyAmount, regularAmount, seconds);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(this.discountAmount);
  }
}
