package ex.books.chapter_11.composite.phone.policy;

import ex.books.chapter_11.composite.phone.Phone;
import ex.books.chapter_11.phone.Call;
import ex.books.common.Money;

public abstract class BasicRatePolicy implements RatePolicy {

  @Override
  public Money calculateFee(Phone phone) {
    Money reseult = Money.ZERO;

    for (Call call : phone.getCalls()) {
      reseult.plus(this.caculateCallFee(call));
    }

    return reseult;
  }

  protected abstract Money caculateCallFee(Call call);
}
