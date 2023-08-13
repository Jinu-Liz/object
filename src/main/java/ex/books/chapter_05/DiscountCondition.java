package ex.books.chapter_05;

import ex.books.chapter_04.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

  private DiscountConditionType type;

  private int sequence;

  private DayOfWeek dayOfWeek;

  private LocalTime startTime;

  private LocalTime endTime;

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

  private boolean isSatisfiedBySequence(Screening screening) {
    return sequence == screening.getSequence();
  }
}
