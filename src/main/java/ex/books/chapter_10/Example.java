package ex.books.chapter_10;

import ex.books.chapter_10.before.Phone;
import ex.books.common.Money;

import java.time.Duration;
import java.time.LocalDateTime;

public class Example {
  public static void main(String[] args) {
    Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
    phone.call(
      new Call(
          LocalDateTime.of(2024, 1, 20, 10, 10),
          LocalDateTime.of(2024, 1, 20, 10, 11)
        )
    );

    phone.call(
      new Call(
        LocalDateTime.of(2024, 1, 21, 10, 10),
        LocalDateTime.of(2024, 1, 21, 10, 11)
      )
    );

    phone.calculateFee();
  }
}
