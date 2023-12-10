package ex.books.chapter_08.policy;

import ex.books.chapter_08.Screening;
import ex.books.common.Money;

public interface DiscountPolicy {

  Money calculateDiscountAmount(Screening screening);

}
