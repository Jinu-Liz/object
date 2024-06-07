package ex.books.chapter_13.movie.condition;

import ex.books.chapter_13.movie.Screening;

public interface DiscountCondition {

  boolean isSatisfiedBy(Screening screening);

}
