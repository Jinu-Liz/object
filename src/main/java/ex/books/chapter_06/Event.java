package ex.books.chapter_06;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {

  private String subject;

  private LocalDateTime from;

  private Duration duration;

  public Event(String subject, LocalDateTime from, Duration duration) {
    this.subject = subject;
    this.from = from;
    this.duration = duration;
  }

  public boolean isSatisfied(RecurringSchedule schedule) {
    if (from.getDayOfWeek() != schedule.getDayOfWeek() || !from.toLocalTime().equals(schedule.getFrom()) || !duration.equals(schedule.getDuration())) {
      reschedule(schedule);

      return false;
    }

    return true;
  }

  /**
   * Event가 RecurringSchedule의 조건을 만족시키지 못할 경우, Event의 상태를 변경 후 false를 반환.
   * isSatisfied가 명령과 쿼리의 두 가지 역할을 동시에 수행하고 있다.
   */
  private void reschedule(RecurringSchedule schedule) {
    from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule)), schedule.getFrom());

    duration = schedule.getDuration();
  }

  private long dayDistance(RecurringSchedule schedule) {

    return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
  }


}
