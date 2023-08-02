package ex.books.chapter_02;

/**
 * 일정 비율 할인 정책
 */
public class PercentDiscountPolicy extends DiscountPolicy {

  private double percent;

  public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
    super(conditions);
    this.percent = percent;
  }

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return screening.getMovieFee().times(percent);
  }
}
