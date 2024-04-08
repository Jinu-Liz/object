package ex.books.chapter_12;

import ex.books.common.Money;

public class Movie {

  private Money fee;

  private DiscountPolicy discountPolicy;

  /**
   * 포함 다형성 예.
   * Movie 클래스는 discountPolicy에게 calculateDiscountAmount 메시지를 전송하지만
   * 실제로 실행되는 메서드는 메시지를 수신한 객체의 타입에 따라 달라진다.
   */
  public Money calculateMovieFee(Screening screening) {
    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }

}
