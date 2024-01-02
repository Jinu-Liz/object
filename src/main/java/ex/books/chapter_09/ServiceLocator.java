package ex.books.chapter_09;

import ex.books.chapter_09.policy.DiscountPolicy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServiceLocator {

  private static ServiceLocator INSTANCE = new ServiceLocator();

  private DiscountPolicy discountPolicy;

  public static DiscountPolicy discountPolicy() {
    return INSTANCE.discountPolicy;
  }

  public static void provide(DiscountPolicy discountPolicy) {
    INSTANCE.discountPolicy = discountPolicy;
  }
}
