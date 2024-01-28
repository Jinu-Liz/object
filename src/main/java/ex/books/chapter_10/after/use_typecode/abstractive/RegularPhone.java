package ex.books.chapter_10.after.use_typecode.abstractive;

import ex.books.chapter_10.Call;
import ex.books.common.Money;

import java.time.Duration;

/**
 * 기존의 Phone이라는 이름은 요금제와 관련된 내용을 구현한다는 사실을 명시적으로 전달하지 못했다.
 */
public class RegularPhone extends Phone {

  private Money amount;

  private Duration seconds;

  public RegularPhone(Money amount, Duration seconds, double taxRate) {
    super(taxRate);
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    return this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
  }
}
