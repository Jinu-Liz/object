package ex.books.chapter_10.before;

import ex.books.chapter_10.Call;
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

/**
 * 세율이 추가되어 변경이 일어나는 경우, Phone과 NightlyDiscountPhone가 함께 수정되어야 한다.
 * 이러한 경우가 늘어날 경우, 많은 코드 더미 속에서 어떤 코드가 중복인지를 파악하는 일은 쉬운 일이 아니다.
 * 중복 코드는 항상 함께 수정되어야 하기 때문에 하나라도 빠트린다면 버그로 이어질 것이다.
 * 더 큰 문제는 중복 코드를 서로 다르게 수정할 수 있다는 점이다.
 * Phone의 calculateFee 메서드에서는 result에 plus 메서드를 호출해서 세금을 더했지만,
 * NightlyDiscountPhone에서는 minus 메서드를 호출하고 있다.
 *
 * 이처럼 중복 코드는 새로운 중복 코드를 부른다.
 * 중복 코드를 제거하지 않은 상태에서 코드를 수정할 수 있는 유일한 방법은 새로운 중복 코드를 추가하는 것 뿐이다.
 * 이는 코드의 일관성을 무너뜨리고, 어플리케이션을 변경에 취약해지그끔 만들며 버그 발생 가능성을 높인다.
 * 중복 코드의 양이 많아질수록 버그의 수는 증가하며, 그와 비례해 코드를 변경하는 속도는 점점 느려진다.
 *
 * 민첩하게 변경하기 위해서는 중복 코드를 제거해야한다.
 * 기회가 생길 때마다 코드를 DRY(Don't Repeat Yourself)하게 만들기 위해 노력해라.
 */
public class NightlyDiscountPhone {

  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount;

  private Money regularAmount;

  private Duration seconds;

  private double taxRate;

  private List<Call> calls = new ArrayList<>();

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
    this.taxRate = taxRate;
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

    return result.minus(result.times(this.taxRate));
  }
}
