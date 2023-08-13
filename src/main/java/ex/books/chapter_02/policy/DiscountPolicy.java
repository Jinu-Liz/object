package ex.books.chapter_02.policy;

import ex.books.common.Money;
import ex.books.chapter_02.entity.Screening;

public interface DiscountPolicy {

  Money calculateDiscountAmount(Screening screening);

}
