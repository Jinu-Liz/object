package ex.books.chapter_08;

import ex.books.chapter_08.policy.AmountDiscountPolicy;
import ex.books.chapter_08.policy.PercentDiscountPolicy;
import ex.books.common.Money;

import java.time.Duration;

public class Example {
  public static void main(String[] args) {
    /**
     * 컴파일타임 의존성을 실행 컨텍스트에 맞는 적절한 런타임 의존성으로 교체하는 것을 '의존성 해결'이라고 부른다.
     * 의존성을 해결하기 위해서는 일반적으로 3가지 방법을 사용한다.
     *
     * 1. 객체를 생성하는 시점에 생성자를 통한 의존성 해결 (생성자 주입)
     * 2. 객체 생성 후, setter 메서드를 통한 의존성 해결 (수정자 주입)
     * 3. 메서드 실행 시 인자를 이용한 의존성 해결 (필드 주입)
     */

    /**
     * 생성자 주입
     */
    Movie avatar = new Movie("아바타",
      Duration.ofMinutes(120),
      Money.wons(10000),
      new AmountDiscountPolicy());

    Movie starwars = new Movie("스타워즈",
      Duration.ofMinutes(180),
      Money.wons(11000),
      new PercentDiscountPolicy());


    /**
     * 수정자 주입
     */
    Movie avatar2 = new Movie("아바타",
      Duration.ofMinutes(120),
      Money.wons(10000));
    avatar2.setDiscountPolicy(new AmountDiscountPolicy());

    Movie starwars2 = new Movie("스타워즈",
      Duration.ofMinutes(180),
      Money.wons(11000));
    starwars2.setDiscountPolicy(new PercentDiscountPolicy());


    /**
     * 필드 주입
     *
     * 지속적으로 의존 관계를 맺을 필요 없이 메서드가 실행되는 동안만 일시적으로 의존관계가 존재해도 무방하거나,
     * 메서드가 실행될 때마다 의존 대상이 매번 달라져야하는 경우에 유용.
     */
    Movie movie = new Movie();
    movie.calculateMovieFee(new Screening(), new AmountDiscountPolicy());

    Movie movie2 = new Movie();
    movie2.calculateMovieFee(new Screening(), new PercentDiscountPolicy());
  }
}
