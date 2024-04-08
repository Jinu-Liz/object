package ex.books.chapter_12;

import ex.books.common.Money;

public interface DiscountPolicy {

  Money calculateDiscountAmount(Screening screening);

}
