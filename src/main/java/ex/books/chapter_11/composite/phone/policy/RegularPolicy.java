package ex.books.chapter_11.composite.phone.policy;

import ex.books.chapter_11.phone.Call;
import ex.books.common.Money;

import java.time.Duration;

public class RegularPolicy extends BasicRatePolicy {

  private Money amount;

  private Duration seconds;

  public RegularPolicy(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money caculateCallFee(Call call) {
    return this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
  }
}
