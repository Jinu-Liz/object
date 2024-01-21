package ex.books.chapter_10.after.use_typecode;

import ex.books.chapter_10.Call;
import ex.books.common.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


/**
 * 상속을 이용하여 코드를 복사하지 않고 코드를 재사용할 수 있다.
 * NightlyDiscountPhone 클래스가 Phone 클래스를 상속받게 만들면
 * 코드를 중복시키지 않고도 코드 대부분을 재사용할 수 있다.
 */
public class NightlyDiscountPhone extends Phone {

  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount;

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
    super(regularAmount, seconds);
    this.nightlyAmount = nightlyAmount;
  }

  /**
   * 부모의 코드를 최대한 활용하고자 로직 수정
   * 그러나 개발자의 의도를 이해하기 전에는 코드를 이해하기가 어렵다.
   * 상속을 염두해두고 설계되지 않은 클래스를 상속을 이용해 재사용하는 것은 생각처럼 쉽지 않다.
   * 원래 기대했던 것은 요금을 차감(minus)하는 것이 아니라 더하는(plus) 것이다.
   * 요구사항과 구현 사이의 차이가 크면 클수록 코드를 이해하기 어려워진다.
   * 잘못된 상속은 이 차이를 더 크게 벌린다.
   *
   * 상속을 이용해 코드를 재사용하기 위해서는 부모클래스의 개발자가 세웠던 가정이나 추론 과정을
   * 정확하게 이해해야 한다. 이는 자식 클래스의 작성자가 부모 클래스의 구현 방법에 대해 정확한 지식을
   * 가져야한다는 것을 의미한다.
   * 따라서 상속은 결합도를 높인다. 그리고 상속이 초래하는 부모 클래스와 자식 클래스 사이의 강한 결합이
   * 코드를 수정하기 어렵게 만든다.
   */
  @Override
  public Money calculateFee() {
    Money result = super.calculateFee();

    Money nightlyFee = Money.ZERO;
    for (Call call : super.getCalls()) {
      if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
        nightlyFee = nightlyAmount.plus(
          super.getAmount().minus(nightlyAmount).times(
            call.getDuration().getSeconds() / super.getSeconds().getSeconds()
          )
        );
      }
    }

    return result.minus(nightlyFee);
  }
}
