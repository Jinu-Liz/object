package ex.books.chapter_11.phone;

import ex.books.common.Money;

import java.util.ArrayList;
import java.util.List;


public abstract class Phone {

  private List<Call> calls = new ArrayList<>();

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }

    return result;
  }

  protected abstract Money calculateCallFee(Call call);

  /**
   * 전체 요금을 계산한 후에 수행할 로직을 추가할 수 있는 기회를 제공
   * 그러나 부모 클래스에 추상 메서드를 추가하면 모든 자식들이 해당 메서드를
   * 오버라이딩해야하는 문제가 발생한다.
   * 또한 모든 추상 메서드의 구현이 동일할 수도 있다.
   * 따라서 유연성은 유지하면서도 중복 코드를 제거할 수 있는 방법은 추상 메서드가 아니라
   * 해당 메서드에 대한 기본 구현을 함께 제공하는 것이다.
   *
   * 이렇게 편의를 위하여 기본 구현을 제공하는 메서드를 훅 메서드(hook method)라고 부른다.
    */
  protected Money afterCalculated(Money fee) {
    return fee;
  };

}
