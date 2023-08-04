package ex.books.chapter_02.entity;

import java.math.BigDecimal;

/**
 * Long 타입 같은 변수는 Money 타입처럼 저장하는 값이 금액과 관련있다는 의미를 전달할 수 없다.
 * 또한 금액과 관련된 로직이 다른 곳에 중복되어 구현되는 것을 막을 수 없다.
 * 의미를 좀 더 명시적이고 분명하게 표현할 수 있다면 객체를 사용하여 해당 개념을 구현.
 */
public class Money {

  public static final Money ZERO = Money.wons(0);

  private final BigDecimal amount;

  public Money(BigDecimal amount) {
    this.amount = amount;
  }

  public static Money wons(long amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public static Money wons(double amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public Money minus(Money amount) {
    return new Money(this.amount.subtract(amount.amount));
  }

  public Money plus(Money amount) {
    return new Money(this.amount.add(amount.amount));
  }

  public Money times(double percent) {
    return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
  }

  public boolean isLessThan(Money other) {
    return amount.compareTo(other.amount) < 0;
  }

  public boolean isGreaterThanOrEqual(Money other) {
    return amount.compareTo(other.amount) >= 0;
  }

}
