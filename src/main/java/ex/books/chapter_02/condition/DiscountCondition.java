package ex.books.chapter_02.condition;

import ex.books.chapter_02.entity.Screening;

public interface DiscountCondition {

  boolean isSatisfiedBy(Screening screening);

}
