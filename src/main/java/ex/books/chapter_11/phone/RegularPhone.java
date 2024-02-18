package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.time.Duration;


public class RegularPhone extends Phone {

  private Money amount;

  private Duration seconds;

  public RegularPhone(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    return this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee;
  }
}
