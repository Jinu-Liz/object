package ex.books.chapter_08;


import ex.books.chapter_08.condition.PeriodCondition;
import ex.books.chapter_08.condition.SequenceCondition;
import ex.books.chapter_08.policy.AmountDiscountPolicy;
import ex.books.chapter_08.policy.DiscountPolicy;
import ex.books.common.Money;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie2 {

  private String title;

  private Duration runningTime;

  private Money fee;

  private DiscountPolicy discountPolicy;

  /**
   * AmountDiscountPolicy의 인스턴스를 생성하기 위해서는 생성자에 전달되는 인자를 알고 있어야 한다.
   * 이는 Movie가 AmountDiscountPolicy에게 더 강하게 결합되도록 만든다.
   * 뿐만 아니라, SequenceCondition과 PeriodCondition에도 의존하도록 만들며 이에 대한 인자들의 정보에 대해서도 결합된다.
   * 결합된 클래스들 생성자에서 인자 목록이나 인자 순서가 바뀌는 경우, 함께 변경되어야 한다.
   *
   * 이를 해결하기 위해서는 인스턴스를 생성하는 로직과 생성된 인스턴스를 사용하는 로직을 분리하는 것이다.
   * AmountDiscountPolicy를 내부에서 생성하는게 아닌, 외부로부터 이미 생성된 인스턴스를 전달받아야 한다.
   */
  public Movie2(String title, Duration runningTime, Money fee) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountPolicy = new AmountDiscountPolicy(Money.wons(800),
      new SequenceCondition(1),
      new SequenceCondition(10),
      new PeriodCondition(
        DayOfWeek.MONDAY,
        LocalTime.of(10, 0),
        LocalTime.of(11, 59)),
      new PeriodCondition(
        DayOfWeek.THURSDAY,
        LocalTime.of(10, 0),
        LocalTime.of(20, 59))
      );
  }

}
