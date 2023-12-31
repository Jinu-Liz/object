package ex.books.chapter_05.entity;

import ex.books.chapter_05.condition.DCCondition;
import ex.books.chapter_05.condition.DiscountCondition;
import ex.books.chapter_05.constant.MovieType;
import ex.books.common.Money;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Getter
@Setter
public abstract class Movie {

  private String title;

  private Duration runningTime;

  private Money fee;

  /**
   * DCCondition은 Movie로부터 PeriodCondition과 SequenceCondition의 존재를 감춘다.
   * 즉, 캡슐화를 시킴으로써 새로운 DCCondition 타입을 추가하더라도 Movie가 영향을 받지 않는다.
   * 이처럼 변경을 캡슐화하도록 책임을 할당하는 것을 PROTECTED VARIATIONS(변경 보호) 패턴이라고 부른다.
   */
  private List<DCCondition> dcConditions;

  private List<DiscountCondition> discountConditions;

  private MovieType movieType;

  private Money discountAmount;

  private double discountPercent;

//  private List<PeriodCondition> periodConditions;
//
//  private List<SequenceCondition> sequenceConditions;

  public Movie(String title, Duration runningTime, Money fee, DCCondition... dcConditions) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.dcConditions = List.of(dcConditions);
  }

  public Money calculateMovieFee(Screening screening) {
    if (isDiscountable(screening)) return fee.minus(calculateDiscountAmount());

    return fee;
  }

  private boolean isDiscountable(Screening screening) {
    return dcConditions.stream()
            .anyMatch(condition -> condition.isSatisfiedBy(screening));
  }

  abstract protected Money calculateDiscountAmount();

  public Money getFee() {
    return this.fee;
  }

  /**
   * conditions가 나눠지면서, Movie가 협력해야하는 클래스가 두 개로 나위어졌다. (DiscountCondition -> SequenceCondition, PeriodCondition)
   * 가장 쉽게 해당 문제를 해결하는 방법은 각 클래스들의 목록을 별도로 유지하는 것이다.
   * 하지만, 이 방법은 PeriodCondition과 SequenceCondition 양쪽 모두에게 결합된다. 클래스 분리 후, 전체적인 결합도가 높아졌다.
   * 또한 수정 후에 새로운 할인 조건을 추가하기가 더 어려워졌다.
   * 새로운 할인 조건 클래스를 담기 위한 List를 인스턴스 변수로 추가해야 한다.
   * 이후, List를 이용하여 할인 조건을 만족하는지 여부를 판단하는 메서드도 추가해야한다.
   * 마지막으로 이 메서드를 호출하도록 isDiscountable 메서드를 수정해야 한다.
   */
//  private boolean checkPeriodConditions(Screening screening) {
//    return periodConditions.stream()
//      .anyMatch(condition -> condition.isSatisfiedBy(screening));
//  }
//
//  private boolean checkSequenceConditions(Screening screening) {
//    return sequenceConditions.stream()
//      .anyMatch(condition -> condition.isSatisfiedBy(screening));
//  }
}
