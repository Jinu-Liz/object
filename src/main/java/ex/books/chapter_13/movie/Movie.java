package ex.books.chapter_13.movie;

import ex.books.chapter_13.movie.policy.DiscountPolicy;
import ex.books.common.Money;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 계약에 의한 설계에 의하면, 협력하는 클라이언트와 슈퍼타입의 인스턴스 사이에는 어떤 계약이 맺어져 있다.
 * 클라이언트와 슈퍼타입은 이 계약을 준수할 때만 정상적으로 협력할 수 있다.
 */
@NoArgsConstructor
@Data
public class Movie {

  private String title;

  private Duration runningTime;

  private Money fee;

  private DiscountPolicy discountPolicy;

  /**
   * 해당 메서드가 정의한 사전조건을 만족시키는 것은 Movie의 책임이다.
   * 따라서 Movie는 사전조건을 위반하는 screening을 전달해서는 안된다.
   */
  public Money calculateMovieFee(Screening screening) {
    if (screening == null || screening.getStartTime().isBefore(LocalDateTime.now())) {
      throw new InvalidScreeningException();
    }

    return fee.minus(discountPolicy.calculateDiscountAmount(screening));
  }

}
