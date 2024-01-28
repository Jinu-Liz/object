package ex.books.chapter_10.after.use_typecode.abstractive;

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
      result = result.plus(calculateCallFee(call));
    }

    return result;
  }

  private Money calculateCallFee(Call call) {
    if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {

      return this.nightlyAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
    } else {

      return this.regularAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
    }
  }
}
