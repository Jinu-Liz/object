package ex.books.chapter_11.composite.phone.policy;

import ex.books.chapter_11.composite.phone.Phone;
import ex.books.common.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {

  private RatePolicy next;

  public AdditionalRatePolicy(RatePolicy next) {
    this.next = next;
  }

  @Override
  public Money calculateFee(Phone phone) {
    Money fee = this.next.calculateFee(phone);

    return afterCalculated(fee);
  }

  abstract protected Money afterCalculated(Money fee);
}
