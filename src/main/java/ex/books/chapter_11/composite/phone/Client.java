package ex.books.chapter_11.composite.phone;

import ex.books.chapter_11.composite.phone.policy.NightlyDiscountPolicy;
import ex.books.chapter_11.composite.phone.policy.RateDiscountablePolicy;
import ex.books.chapter_11.composite.phone.policy.RegularPolicy;
import ex.books.chapter_11.composite.phone.policy.TaxablePolicy;
import ex.books.common.Money;

import java.time.Duration;

public class Client {

  public static void main(String[] args) {
    Phone regularPhone = new Phone(
      new RegularPolicy(
        Money.wons(10),
        Duration.ofSeconds(10)
      )
    );

    Phone nightPhone = new Phone(
      new NightlyDiscountPolicy(
        Money.wons(5),
        Money.wons(10),
        Duration.ofSeconds(10)
      )
    );

    // 부가 정책 합성
    Phone taxAdditionalPhone = new Phone(
      new TaxablePolicy(
        0.05,
        new RateDiscountablePolicy(
          Money.wons(1000),
          new RegularPolicy(
            Money.wons(10),
            Duration.ofSeconds(10)
          )
        )
      )
    );
  }
}
