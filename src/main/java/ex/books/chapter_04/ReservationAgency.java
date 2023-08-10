package ex.books.chapter_04;

import ex.books.chapter_02.entity.Customer;
import ex.books.chapter_02.entity.Money;

/**
 * 대부분의 제어 로직을 가지고 있는 제어 객체인 ReservationAgency는 모든 데이터 객체에 의존한다.
 * DiscountCondition의 데이터가 변경되어도, Screening의 데이터가 변경되어도 해당 객체들 뿐만 아니라
 * ReservationAgency도 함께 수정해야 한다.
 */
public class ReservationAgency {

  public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
    Money fee = screening.calculateFee(audienceCount);

    return new Reservation(customer, screening, fee, audienceCount);
  }

//  public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
//    Movie movie = screening.getMovie();
//
//    boolean discountable = false;
//    for (DiscountCondition condition : movie.getDiscountConditions()) {
//      if (condition.getType() == DiscountConditionType.PERIOD) {
//        discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
//          condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
//          condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
//      } else {
//        discountable = condition.getSequence() == screening.getSequence();
//      }
//
//      if (discountable) break;
//    }
//
//    /**
//     * 만약 fee의 타입을 변경해야한다면, Movie의 getFee의 반환 타입도 수정해야 한다.
//     * 또한 getFee 메서드를 호출하는 ReservationAgency의 구현 또한 변경 타입에 맞게 수정해야 한다.
//     * fee의 타입 변경으로 인해 협력하는 클래스가 변경되기 때문에 getFee 메서드는 fee를 정상적으로 캡슐화하지 못한다.
//     */
//    Money fee;
//    if (discountable) {
//      Money discountAmount = Money.ZERO;
//      switch (movie.getMovieType()) {
//        case AMOUNT_DISCOUNT :
//          discountAmount = movie.getDiscountAmount();
//          break;
//
//        case PERCENT_DISCOUNT :
//          discountAmount = movie.getFee().times(movie.getDiscountPercent());
//          break;
//
//        case NONE_DISCOUNT : default :
//        break;
//      }
//
//      fee = movie.getFee().minus(discountAmount);
//    } else {
//      fee = movie.getFee();
//    }
//
//    return new Reservation(customer, screening, fee, audienceCount);
//  }

}
