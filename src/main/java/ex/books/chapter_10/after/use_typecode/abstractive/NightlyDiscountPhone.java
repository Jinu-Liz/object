package ex.books.chapter_10.after.use_typecode.abstractive;

import ex.books.chapter_10.Call;
import ex.books.common.Money;

import java.time.Duration;


public class NightlyDiscountPhone extends Phone {

  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount;

  private Money regularAmount;

  private Duration seconds;

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    super(taxRate);
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {

      return this.nightlyAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
    } else {

      return this.regularAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
    }
  }
}
