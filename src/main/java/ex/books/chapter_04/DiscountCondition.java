package ex.books.chapter_04;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static ex.books.chapter_04.DiscountConditionType.*;

public class DiscountCondition {

  private DiscountConditionType type;

  private int sequence;

  private DayOfWeek dayOfWeek;

  private LocalTime startTime;

  private LocalTime endTime;

  public DiscountConditionType getType() {
    return type;
  }

  public void setType(DiscountConditionType type) {
    this.type = type;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public DayOfWeek getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(DayOfWeek dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }

  public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
    if (type != PERIOD) throw new IllegalArgumentException();

    return this.dayOfWeek.equals(dayOfWeek) &&
      !this.startTime.isAfter(time) &&
      !this.endTime.isBefore(time);
  }

  public boolean isDiscountable(int sequence) {
    if (type != SEQUENCE) throw new IllegalArgumentException();

    return this.sequence == sequence;
  }
}
