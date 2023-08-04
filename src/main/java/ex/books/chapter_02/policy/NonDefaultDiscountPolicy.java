package ex.books.chapter_02.policy;

import ex.books.chapter_02.entity.Money;
import ex.books.chapter_02.entity.Screening;

public class NonDefaultDiscountPolicy implements DiscountPolicy {

  /**
   * 부모 클래스였던 DefaultDiscountPolicy에서 할인 조건이 없을 경우, getDiscountAmount를 호출하지 않는다.
   * 이는 DefaultDiscountPolicy와 NonDefaultDiscountPolicy를 개념적으로 결합시킨다.
   * getDiscountAmount가 호출되지 않을 경우, DefaultDiscountPolicy와가 0원을 반환할 것이라는 사실을 가정하고 있기 때문이다.
   * 따라서 DiscountPolicy라는 interface를 구현하도록 변경하면 개념적인 혼란과 결합을 제거할 수 있다.
   */
//  @Override
//  protected Money getDiscountAmount(Screening screening) {
//    return Money.ZERO;
//  }

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    return Money.ZERO;
  }
}
