package ex.books.chapter_10.after.use_typecode.abstractive;

import ex.books.chapter_10.Call;
import ex.books.common.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * 중복되는 코드를 추상화된 부모클래스로 이전
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
