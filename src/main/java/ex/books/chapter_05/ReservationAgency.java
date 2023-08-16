package ex.books.chapter_05;

import ex.books.chapter_04.DiscountConditionType;
import ex.books.common.Money;

/**
 * 객체로 책임을 분배할 때 가장 먼저 할 일은 메서드를 응집도 있는 수준으로 분해하는 것이다.
 * 작고 응집도 높은 메서드로 분리하면 각 메서드를 적절한 클래스로 이동하기가 더 수월해지기 때문ㅇ다.
 */
public class ReservationAgency {

  public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
    boolean discountable = checkDiscountable(screening);
    Money fee = calculateFee(screening, discountable, audienceCount);

    return createReservation(screening, customer, audienceCount, fee);
  }

  private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
    if (discountable) {
      return screening.getMovie().getFee()
        .minus(calculateDiscountedFee(screening.getMovie()))
        .times(audienceCount);
    }

    return screening.getMovie().getFee().times(audienceCount);
  }

  private Money calculateDiscountedFee(Movie movie) {
    switch (movie.getMovieType()) {
      case AMOUNT_DISCOUNT -> calculateAmountDiscountedFee(movie);

      case PERCENT_DISCOUNT -> calculatePercentDiscountedFee(movie);

      case NONE_DISCOUNT -> calculateNoneDiscountedFee(movie);
    }

    throw new IllegalArgumentException();
  }

  private Money calculateNoneDiscountedFee(Movie movie) {
    return Money.ZERO;
  }

  private Money calculatePercentDiscountedFee(Movie movie) {
    return movie.getFee().times(movie.getDiscountPercent());
  }

  private Money calculateAmountDiscountedFee(Movie movie) {
    return movie.getDiscountAmount();
  }

  private boolean checkDiscountable(Screening screening) {
    return screening.getMovie().getDiscountConditions().stream()
      .anyMatch(condition -> condition.isDiscountable(screening));
  }

  private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
    return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
      !condition.getStartTime().isAfter(screening.getWhenScreened().toLocalTime()) &&
      !condition.getEndTime().isBefore(screening.getWhenScreened().toLocalTime());
  }

  private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
    return condition.getSequence() == screening.getSequence();
  }

  private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
    return new Reservation(customer, screening, fee, audienceCount);
  }

}
