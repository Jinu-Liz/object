package ex.books.chapter_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

  private List<DiscountCondition> conditions = new ArrayList<>();

  private Money fee;

  public DiscountPolicy(DiscountCondition ... conditions) {
    this.conditions = Arrays.asList(conditions);
  }

  public Money calculateDiscountAmount(Screening screening) {
    for (DiscountCondition each : conditions) {
      if (each.isSatisfiedBy(screening)) return getDiscountAmount(screening);
    }

    return Money.ZERO;
  }

  abstract protected Money getDiscountAmount(Screening screening);
}
