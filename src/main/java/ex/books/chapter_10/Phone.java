package ex.books.chapter_10;

import ex.books.common.Money;
import lombok.Getter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Phone {

  private Money amount;

  private Duration seconds;

  private double taxRate;

  private List<Call> calls = new ArrayList<>();

  public Phone(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  public Phone(Money amount, Duration seconds, double taxRate) {
    this.amount = amount;
    this.seconds = seconds;
    this.taxRate = taxRate;
  }

  public void call(Call call) {
    this.calls.add(call);
  }

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : calls) {
      result = result.plus(this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds()));
    }

    return result.plus(result.times(this.taxRate));
  }
}
