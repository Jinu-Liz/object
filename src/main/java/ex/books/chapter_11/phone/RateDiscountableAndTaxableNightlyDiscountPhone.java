package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.time.Duration;

/**
 * 기본 요금 할인 정책을 적용 후, 세금을 부과한 심야 요금제
 *
 * 부가 정책은 자유롭게 조합할 수 있어야하고 적용되는 순서 역시 임의로 결정할 수 있어야 한다.
 * 요구사항에 따르면 세금정책 및 기본 요금 할인 정책을 함께 적용할 수 있어야 하고,
 * 선 세금정책 후 할인요금 또는 선 할인요금 후 세금정책이 가능해야 한다.
 * 이를 상속으로 풀어낼 경우, 새로운 정책을 추가하기 위해서는 불필요하게 많은 수의 클래스를 상속 계층 안에 추가해야하기 때문에
 * 새로운 정책을 추가하기가 어렵다.
 *
 * 상속 계층에 정책이 추가되는 경우, 조합 가능한 정책의 수만큼 새로운 클래스를 추가해야 한다.
 * 이처럼 상속의 남용으로 하나의 기능을 추가하기 위해 필요 이상으로 많은 수의 클래스를 추가해야 하는 경우를 가리켜
 * 클래스 폭발(class explosion) 문제 또는 조합의 폭발(combinational explosion) 문제라고 부른다.
 *
 * 이는 자식 클래스가 부모 클래스의 구현에 강하게 결합되도록 강요하는 상속의 근본적인 한계 때문에 발생한다.
 * 컴파일 타임에 결정된 자식 클래스와 부모 클래스 사이의 관계는 변경될 수 없기 때문에, 다양한 조합이 필요한 상황에서
 * 유일한 해결 방법은 조합의 수만큼 새로운 클래스를 추가하는 것 뿐이다.
 *
 * 이 문제를 해결할 수 있는 최선의 방법은 상속을 포기하는 것이다.
 */
public class RateDiscountableAndTaxableNightlyDiscountPhone extends RateDiscountableNightlyDiscountPhone {

  private double taxRate;

  public RateDiscountableAndTaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount, double taxRate) {
    super(nightlyAmount, regularAmount, seconds, discountAmount);
    this.taxRate = taxRate;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return super.afterCalculated(fee).plus(fee.times(this.taxRate));
  }
}
