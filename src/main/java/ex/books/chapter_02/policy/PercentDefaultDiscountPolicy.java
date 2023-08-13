package ex.books.chapter_02.policy;

import ex.books.chapter_02.condition.DiscountCondition;
import ex.books.common.Money;
import ex.books.chapter_02.entity.Screening;

/**
 * 일정 비율 할인 정책
 */
public class PercentDefaultDiscountPolicy extends DefaultDiscountPolicy {

  private double percent;

  public PercentDefaultDiscountPolicy(double percent, DiscountCondition... conditions) {
    super(conditions);
    this.percent = percent;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return screening.getMovieFee().times(percent);
  }
}
