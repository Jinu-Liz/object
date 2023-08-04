package ex.books.chapter_02.policy;

import ex.books.chapter_02.condition.DiscountCondition;
import ex.books.chapter_02.entity.Money;
import ex.books.chapter_02.entity.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

  private List<DiscountCondition> conditions = new ArrayList<>();

  private Money fee;

  public DefaultDiscountPolicy(DiscountCondition ... conditions) {
    this.conditions = Arrays.asList(conditions);
  }

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    for (DiscountCondition each : conditions) {
      if (each.isSatisfiedBy(screening)) return getDiscountAmount(screening);
    }

    return Money.ZERO;
  }

  /**
   * DiscountPolicy는 할인 여부와 요금 계산에 필요한 전체적인 흐름은 정의하지만
   * 실제 요금 계산 부분은 getDiscountAmount 메서드에 위임.
   * 이처럼 부모 클래스에 기본 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에 위임하는 디자인 패턴이
   * TEMPLATE METHOD 패턴.
   */
  abstract protected Money getDiscountAmount(Screening screening);
}
