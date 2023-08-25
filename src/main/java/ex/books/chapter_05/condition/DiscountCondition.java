package ex.books.chapter_05.condition;

import ex.books.chapter_04.DiscountConditionType;
import ex.books.chapter_05.entity.Screening;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 현재 DiscountCondition의 가장 큰 문제점은 변경에 취약한 클래스이다.
 * 코드를 수정해야하는 이유를 하나 이상 가지고 있기 때문인데,
 * 1. 새로운 할인 조건이 추가 될 경우 if ~ else 구문을 수정해야 한다.
 * 2. 순번 조건을 판단하는 로직이 변경될 경우, isSatisfiedBySequence 메서드 내부 구현을 수정해야한다.
 * 3. 기간 조건을 판단하는 로직이 변경될 경우, isSatisfiedByPeriod 메서드 내부 구현을 수정해야한다.
 *
 * 따라서, 응집도가 낮다고 할 수 있는데, 이 문제를 해결하기 위해서는 '변경의 이유에 따라 분리' 해야한다.
 * 첫 번째 방법은 인스턴스 변수가 초기화되는 시점 살펴보고, 함께 초기화되는 속성을 기준으로 코드를 분리해야 한다.
 * 두 번째 방법은 메서드들이 인스턴스 변수를 사용하는 방식을 보고, 속성 그룹과 해당 그룹에 접근하는 메서드 그룹을 기준으로 코드를 분리해야 한다.
 */
@Getter
@Setter
public class DiscountCondition {

  private DiscountConditionType type;

  private int sequence;

  private DayOfWeek dayOfWeek;

  private LocalTime startTime;

  private LocalTime endTime;

  /**
   * 해당 메서드가 ReservationAgency에 속할 때는 구현의 일부였지만
   * DiscountCondition으로 이동한 후에는 퍼블릭 인터페이스의 일부가 되었다.
   */
  public boolean isDiscountable(Screening screening) {
    if (this.type == DiscountConditionType.PERIOD) return isSatisfiedByPeriod(screening);

    return isSatisfiedBySequence(screening);
  }

  public boolean isSatisfiedBy(Screening screening) {
    if (type == DiscountConditionType.PERIOD) {
      return isSatisfiedBy(screening);
    }

    return isSatisfiedBySequence(screening);
  }

  private boolean isSatisfiedByPeriod(Screening screening) {
    return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
      !startTime.isAfter(screening.getWhenScreened().toLocalTime()) &&
      !endTime.isBefore(screening.getWhenScreened().toLocalTime());
  }

  /**
   * 순번 조건의 경우 sequence는 초기화되지만, dayOfWeek, startTime, endTime은 초기화되지 않는다. (or 사용하지 않는다.)
   * 반대의 경우에는 sequence가 초기화되지 않는다. (or 사용하지 않는다.)
   * 클래스의 속성이 서로 다른 시점에 초기화되거나 일부만 초기화된다는 것은 응집도가 낮다는 증거다.
   */
  private boolean isSatisfiedBySequence(Screening screening) {
    return sequence == screening.getSequence();
  }
}
