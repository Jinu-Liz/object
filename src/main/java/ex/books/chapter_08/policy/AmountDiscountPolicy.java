package ex.books.chapter_08.policy;

import ex.books.chapter_08.Screening;
import ex.books.common.Money;

public class AmountDiscountPolicy implements DiscountPolicy {

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    return null;
  }

}
