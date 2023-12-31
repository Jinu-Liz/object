package ex.books.chapter_09.policy;

import ex.books.chapter_08.Screening;
import ex.books.common.Money;

public class NoneDiscountPolicy implements DiscountPolicy {

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    return null;
  }
}
