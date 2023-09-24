package ex.books.chapter_06;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Example06 {
  public static void main(String[] args) {
    Event meeting = new Event(
      "회의",
      LocalDateTime.of(2023, 9, 24, 5, 30),
      Duration.ofMinutes(30)
    );

    RecurringSchedule schedule = new RecurringSchedule(
      "회의",
      DayOfWeek.WEDNESDAY,
      LocalTime.of(10, 30),
      Duration.ofMinutes(30)
    );

    assert meeting.isSatisfied(schedule);
  }
}
