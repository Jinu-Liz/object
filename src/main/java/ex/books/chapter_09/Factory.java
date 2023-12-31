package ex.books.chapter_09;

import ex.books.chapter_09.policy.AmountDiscountPolicy;
import ex.books.common.Money;

import java.time.Duration;

public class Factory {

  public Movie createAvatarMovie() {
    return new Movie(
      "아바타",
      Duration.ofMinutes(120),
      Money.wons(10000),
      new AmountDiscountPolicy()
    );
  }

}
