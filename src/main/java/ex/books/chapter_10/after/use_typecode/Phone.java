package ex.books.chapter_10.after.use_typecode;

import ex.books.chapter_10.Call;
import ex.books.common.Money;
import lombok.Getter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 중복 코드를 제거하는 한 가지 방법은 클래스를 하나로 합치는 것이다.
 * 그러나 타입 코드를 사용하는 클래스는 낮은 응집도와 높은 결합도라는 문제에 시달리게 된다.
 */
@Getter
public class Phone {

  private static final int LATE_NIGHT_HOUR = 22;

  enum PhoneType { REGULAR, NIGHTLY }

  private PhoneType type;

  private Money amount;

  private Money regularAmount;

  private Money nightlyAmount;

  private Duration seconds;

  private List<Call> calls = new ArrayList<>();

  public Phone(Money amount, Duration seconds) {
    this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
  }

  public Phone(Money regularAmount, Money nightlyAmount, Duration seconds) {
    this(PhoneType.REGULAR, Money.ZERO, nightlyAmount, regularAmount, seconds);
  }

  public Phone(PhoneType type, Money amount, Money regularAmount, Money nightlyAmount, Duration seconds) {
    this.type = type;
    this.amount = amount;
    this.regularAmount = regularAmount;
    this.nightlyAmount = nightlyAmount;
    this.seconds = seconds;
  }

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : this.calls) {
      if (type == PhoneType.REGULAR) {
        result.plus(
          amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds())
        );
      } else {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
          result = result.plus(
            this.nightlyAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds())
          );
        } else {
          result = result.plus(
            this.regularAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds())
          );
        }
      }
    }

    return result;
  }
}
