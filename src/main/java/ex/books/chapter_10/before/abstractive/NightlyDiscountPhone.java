package ex.books.chapter_10.before.abstractive;

import ex.books.chapter_10.Call;
import ex.books.common.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class NightlyDiscountPhone {

  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount;

  private Money regularAmount;

  private Duration seconds;

  private List<Call> calls = new ArrayList<>();

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : this.calls) {
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

    return result;
  }
}
