package ex.books.chapter_04;

import ex.books.chapter_02.entity.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static ex.books.chapter_04.DiscountConditionType.*;
import static ex.books.chapter_04.MovieType.*;

/**
 * 데이터 중심으로 설계한 Movie를 보면 getter/setter를 통해서만 객체 내부 상태에 접근할 수 있다.
 * 따라서 캡슐화의 원칙을 지키고 있는 것처럼 보이지만 Movie 내부에 해당 타입의 변수가 존재한다는 사실을 노골적으로 드러낸다.
 * (ex: getFee와 setFee는 Money 타입의 fee라는 이름의 변수가 존재한다는 것을 드러냄)
 * 이는 객체가 수행할 책임이 아니라 내부에 저장할 데이터에 초첨을 맞추었기 때문에 발생한다.
 */
public class Movie {

  private String title;

  private Duration runningTime;

  private Money fee;

  private List<DiscountCondition> discountConditions;

  private MovieType movieType;

  private Money discountAmount;

  private double discountPercent;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Duration getRunningTime() {
    return runningTime;
  }

  public void setRunningTime(Duration runningTime) {
    this.runningTime = runningTime;
  }

  public Money getFee() {
    return fee;
  }

  public void setFee(Money fee) {
    this.fee = fee;
  }

  public List<DiscountCondition> getDiscountConditions() {
    return discountConditions;
  }

  public void setDiscountConditions(List<DiscountCondition> discountConditions) {
    this.discountConditions = discountConditions;
  }

  public MovieType getMovieType() {
    return movieType;
  }

  public void setMovieType(MovieType movieType) {
    this.movieType = movieType;
  }

  public Money getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountAmount(Money discountAmount) {
    this.discountAmount = discountAmount;
  }

  public double getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(double discountPercent) {
    this.discountPercent = discountPercent;
  }

  public Money calculateAmountDiscountedFee() {
    if (movieType != AMOUNT_DISCOUNT) throw new IllegalArgumentException();

    return fee.minus(discountAmount);
  }

  public Money calculatePercentDiscountedFee() {
    if (movieType != PERCENT_DISCOUNT) throw new IllegalArgumentException();

    return fee.minus(fee.times(discountPercent));
  }

  public Money calculateNoneDiscountedFee() {
    if (movieType != NONE_DISCOUNT) throw new IllegalArgumentException();

    return fee;
  }

  public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
    for (DiscountCondition condition : discountConditions) {
      if (condition.getType() == PERIOD) {
        if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) return true;
      } else {
        if (condition.isDiscountable(sequence)) return true;
      }
    }

    return false;
  }
}
