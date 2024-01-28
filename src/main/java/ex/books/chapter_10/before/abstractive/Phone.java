package ex.books.chapter_10.before.abstractive;

import ex.books.chapter_10.Call;
import ex.books.common.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {

  private Money amount;

  private Duration seconds;

  private List<Call> calls = new ArrayList<>();

  public Phone(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : this.calls) {
      result = result.plus(this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds()));
    }

    return result;
  }
}
