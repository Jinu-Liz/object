package ex.books.chapter_09.condition;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@AllArgsConstructor
public class PeriodCondition {

  DayOfWeek dayOfWeek;

  LocalTime startTime;

  LocalTime endTime;

}
