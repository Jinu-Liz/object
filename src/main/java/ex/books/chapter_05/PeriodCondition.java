package ex.books.chapter_05;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 클래스를 분리함으로써 모든 인스턴스 변수를 함께 초기화하고, 동일한 인스턴스 변수 그룹을 사용하게 됐다.
 * 결과적으로 개별 클래스들의 응집도가 향상되었다.
 */
public class PeriodCondition {

  private DayOfWeek dayOfWeek;

  private LocalTime startTime;

  private LocalTime endTime;

  public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public boolean isSatidfiedBy(Screening screening) {
    return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
      !startTime.isAfter(screening.getWhenScreened().toLocalTime()) &&
      !endTime.isBefore(screening.getWhenScreened().toLocalTime());
  }
}
