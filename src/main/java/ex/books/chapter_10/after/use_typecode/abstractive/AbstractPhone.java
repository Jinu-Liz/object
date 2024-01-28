package ex.books.chapter_10.after.use_typecode.abstractive;

import ex.books.chapter_10.Call;
import ex.books.common.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * 중복되는 코드를 추상화된 부모 클래스로 이전
 *
 * 이제 부모 클래스에서 정의한 추상 메서드인 calculateCallFee에만 의존한다.
 * 해당 메서드의 시그니처가 변경되지 않는 한 부모 클래스의 내부 구현이 변경되더라도
 * 자식 클래스는 영향을 받지 않는다.
 * 부모 클래스 역시 자신의 내부에 구현된 추상 메서드를 호출하기 때문에 추상화에 의존한다고 할 수 있다.
 * 추상 클래스인 AbstractPhone에 의존하기 때문에 의존성 역전 원칙도 준수한다.
 * 새로운 요금제가 필요하면 AbstractPhone을 상속받아 calculateCallFee 메서드만 오버라이딩하면 되기 때문에
 * 요금제를 추가하기도 쉽다.
 */
public abstract class AbstractPhone {

  private List<Call> calls = new ArrayList<>();

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }

    return result;
  }

  /**
   * 구현은 그대로 두고, 공통 부분인 시그니처만 부모 클래스로 이동.
   */
  abstract protected Money calculateCallFee(Call call);

}
