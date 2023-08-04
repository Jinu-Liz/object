package ex.books.chapter_02.policy;

import ex.books.chapter_02.entity.Money;
import ex.books.chapter_02.entity.Screening;

public class NonDiscountPolicy extends DiscountPolicy {

  @Override
  protected Money getDiscountAmount(Screening screening) {
    return Money.ZERO;
  }
}
