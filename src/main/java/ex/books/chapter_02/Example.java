package ex.books.chapter_02;

import ex.books.chapter_02.condition.PeriodCondition;
import ex.books.chapter_02.condition.SequenceContidion;
import ex.books.chapter_02.entity.Money;
import ex.books.chapter_02.entity.Movie;
import ex.books.chapter_02.policy.AmountDiscountPolicy;
import ex.books.chapter_02.policy.PercentDiscountPolicy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Example {
  public static void main(String[] args) {
    /**
     * 금액 할인 정책이 적용되고, 두 개의 순서 조건과 두 개의 기간 조건을 이용하여
     * 할인 여부 판단한다는 것을 알 수 있음.
     */
    Movie avatar = new Movie("아바타",
      Duration.ofMinutes(120),
      Money.wons(10000),
      new AmountDiscountPolicy(Money.wons(800),
        new SequenceContidion(1),
        new SequenceContidion(10),
        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
        ));

    /**
     * 10%의 비율 할인 전책이 적용되고, 두 개의 기간 조건과 한 개의 순서 조건을 이용하여
     * 할인 여부를 판단.
     */
    Movie titanic = new Movie("타이타닉",
      Duration.ofMinutes(180),
      Money.wons(11000),
      new PercentDiscountPolicy(0.1,
        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
        new SequenceContidion(2),
        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59)))
    );
  }

  /**
   * Movie의 코드에는 AmountDiscountPolicy나 PercentDiscountPolicy에 대한 의존성이 존재하지 않는다.
   * 그럼에도 불구하고 해당 정책들이 정해지는 것은 실행 시점에 의존성이 주입되기 때문이다.
   * 따라서 코드의 의존성과 실행 시점의 의존성이 서도 다를 수 있다는 것.
   * -> 클래스 사이의 의존성과 객체 사이의 의존성은 동일하지 않을 수 있다.
   */
}
