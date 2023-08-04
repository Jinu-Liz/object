package ex.books.chapter_02.policy;

import ex.books.chapter_02.condition.DiscountCondition;
import ex.books.chapter_02.entity.Money;
import ex.books.chapter_02.entity.Screening;

/**
 * 일정 금액 할인 정책
 */
public class AmountDiscountPolicy extends DiscountPolicy {

  private Money discountAmount;

  public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
    super(conditions);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return discountAmount;
  }
}