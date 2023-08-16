package ex.books.chapter_05;

import ex.books.chapter_02.entity.Customer;
import ex.books.chapter_04.DiscountCondition;
import ex.books.chapter_04.DiscountConditionType;
import ex.books.chapter_04.Movie;
import ex.books.chapter_04.Reservation;
import ex.books.chapter_04.Screening;
import ex.books.common.Money;

public class ReservationAgency {

  public ex.books.chapter_04.Reservation reserve(ex.books.chapter_04.Screening screening, Customer customer, int audienceCount) {
    boolean discountable = checkDiscountable(screening);
    Money fee = calculateFee(screening, discountable, audienceCount);

    return createReservation(screening, customer, audienceCount, fee);
  }

  private Money calculateFee(ex.books.chapter_04.Screening screening, boolean discountable, int audienceCount) {
    if (discountable) {
      return screening.getMovie().getFee()
        .minus(calculateDiscountedFee(screening.getMovie()))
        .times(audienceCount);
    }

    return screening.getMovie().getFee().times(audienceCount);
  }

  private Money calculateDiscountedFee(ex.books.chapter_04.Movie movie) {
    switch (movie.getMovieType()) {
      case AMOUNT_DISCOUNT -> calculateAmountDiscountedFee(movie);

      case PERCENT_DISCOUNT -> calculatePercentDiscountedFee(movie);

      case NONE_DISCOUNT -> calculateNoneDiscountedFee(movie);
    }

    throw new IllegalArgumentException();
  }

  private Money calculateNoneDiscountedFee(ex.books.chapter_04.Movie movie) {
    return Money.ZERO;
  }

  private Money calculatePercentDiscountedFee(ex.books.chapter_04.Movie movie) {
    return movie.getFee().times(movie.getDiscountPercent());
  }

  private Money calculateAmountDiscountedFee(Movie movie) {
    return movie.getDiscountAmount();
  }

  private boolean checkDiscountable(ex.books.chapter_04.Screening screening) {
    return screening.getMovie().getDiscountConditions().stream()
      .anyMatch(condition -> isDiscountable(condition, screening));
  }

  private boolean isDiscountable(ex.books.chapter_04.DiscountCondition condition, ex.books.chapter_04.Screening screening) {
    if (condition.getType() == DiscountConditionType.PERIOD) return isSatisfiedByPeriod(condition, screening);

    return isSatisfiedBySequence(condition, screening);
  }

  private boolean isSatisfiedByPeriod(ex.books.chapter_04.DiscountCondition condition, ex.books.chapter_04.Screening screening) {
    return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
      !condition.getStartTime().isAfter(screening.getWhenScreened().toLocalTime()) &&
      !condition.getEndTime().isBefore(screening.getWhenScreened().toLocalTime());
  }

  private boolean isSatisfiedBySequence(DiscountCondition condition, ex.books.chapter_04.Screening screening) {
    return condition.getSequence() == screening.getSequence();
  }

  private ex.books.chapter_04.Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
    return new Reservation(customer, screening, fee, audienceCount);
  }

}
