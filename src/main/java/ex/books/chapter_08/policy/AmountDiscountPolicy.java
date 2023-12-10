package ex.books.chapter_08.policy;

import ex.books.chapter_08.Screening;
import ex.books.chapter_08.condition.PeriodCondition;
import ex.books.chapter_08.condition.SequenceCondition;
import ex.books.common.Money;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AmountDiscountPolicy implements DiscountPolicy {

  public AmountDiscountPolicy(Money money,
                              SequenceCondition sequenceCondition1,
                              SequenceCondition sequenceCondition2,
                              PeriodCondition periodCondition1,
                              PeriodCondition periodCondition2
                              ) { }

  @Override
  public Money calculateDiscountAmount(Screening screening) {
    return null;
  }

}
