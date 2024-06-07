package ex.books.chapter_13.movie.policy;

import ex.books.chapter_13.movie.Screening;
import ex.books.chapter_13.movie.condition.DiscountCondition;
import ex.books.common.Money;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class DiscountPolicy {

  private List<DiscountCondition> conditions = new ArrayList<>();

  public Money calculateDiscountAmount(Screening screening) {
    checkPrecondition(screening);

    Money amount = Money.ZERO;
    for (DiscountCondition each : conditions) {
      if (each.isSatisfiedBy(screening)) {
        amount = getDiscountAmount(screening);
        checkPostCondition(amount);

        return amount;
      }
    }

    amount = screening.getMovieFee();
    checkPostCondition(amount);

    return amount;
  }

  /**
   * screening이 null이 아니고 아직 영화 시작 시간 이전이라고 가정
   */
  protected void checkPrecondition(Screening screening) {
    assert screening != null && screening.getStartTime().isAfter(LocalDateTime.now());
  }

  /**
   * 메서드 반환값이 null이 아니어야하고,
   * 청구되는 요금이기 때문에 최소한 0원보다 커야 한다.
   */
  protected void checkPostCondition(Money amount) {
    assert amount != null && amount.isGreaterThanOrEqual(Money.ZERO);
  }

  abstract protected Money getDiscountAmount(Screening screening);
}
