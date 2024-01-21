package ex.books.chapter_10;

import ex.books.common.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 심야 요금제가 추가됨에 따라 심야 할인 요금제를 구현하는 객체
 * Phone을 복붙해서 조금 수정한 것 말고는 코드가 거의 비슷하다.
 * 이 방법은 짧은 시간 안에 요구사항을 구현할 수 있게 해주지만,
 * Phone과 NightlyDiscountPhone 사이에는 중복 코드가 존재하기 때문에 시한폭탄을 안고 있는 것과 같다.
 * 추후 코드를 변경해야할 때 폭탄의 뇌관이 당겨질지 아닐지 그 누구도 알지 못한다.
 */
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

    for (Call call : calls) {
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
