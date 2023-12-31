package ex.books.chapter_09.policy;

import ex.books.chapter_09.Screening;
import ex.books.common.Money;

public interface DiscountPolicy {

  Money calculateDiscountAmount(Screening screening);

}
