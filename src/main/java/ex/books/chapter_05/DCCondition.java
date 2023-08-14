package ex.books.chapter_05;

/**
 * 역할을 사용하여 객체의 구체적인 타입을 추상화한다.
 * 역할을 대체할 클래스들 사이에서 구현을 공유해야 할 필요가 있다면 추상클래스를,
 * 구현을 공유할 필요 없이 역할을 대체하는 객체들의 책임만 정의하고 싶다면 인터페이스를 사용한다.
 */
public interface DCCondition {

  boolean isSatisfiedBy(Screening screening);

}
