package ex.books.chapter_12.lecture;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Lecture lecture = new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81, 95, 75, 50, 45));
    String evaluation = lecture.evaluate();
    System.out.println("evaluation = " + evaluation);

    Lecture lecture2 = new GradeLecture(
      "객체지향 프로그래밍",
      70,
      Arrays.asList(
        new Grade("A", 100, 95),
        new Grade("B", 94, 80),
        new Grade("C", 79, 70),
        new Grade("D", 69, 50),
        new Grade("F", 49, 0)
      ),
      Arrays.asList(81, 95, 75, 50, 45)
    );

    // 오버라이딩한 자식 메서드가 실행
    String lecture2Evaluate = lecture2.evaluate();
    System.out.println("lecture2Evaluate = " + lecture2Evaluate);

    Professor professor = new Professor("다익스트라", lecture);

    /**
     * Professor에서 받는 인자는 Lecture 타입이지만,
     * GradeLecture를 넣어도 문제가 없다.
     * 부모 클래스(Lecture) 타입으로 선언된 변수에 자식 클래스(GradeLecture)의 인스턴스를 할당하는 것이 가능하기 때문.
     * 이를 '업캐스팅' 이라고 한다.
     *
     * 선언된 변수의 타입이 아니라 메시지를 수신하는 객체의 타입에 따라 실행하는 메서드가 결정된다.
     * 니는 객체지향시스템이 메시지를 처리할 적절한 메서드를 컴파일 시점이 아니라 실행 시점에 결정하기 때문에 가능.
     * 이를 '동적 바인딩' 이라 부른다.
     */
    Professor professor1 = new Professor("다익스트라", lecture2);

    String statistics = professor.compileStatistics();
    System.out.println("statistics = " + statistics);

    String statistics1 = professor1.compileStatistics();
    System.out.println("statistics1 = " + statistics1);

    Lecture downCast = new GradeLecture(
      "객체지향 프로그래밍",
      70,
      Arrays.asList(
        new Grade("A", 100, 95),
        new Grade("B", 94, 80),
        new Grade("C", 79, 70),
        new Grade("D", 69, 50),
        new Grade("F", 49, 0)
      ),
      Arrays.asList(81, 95, 75, 50, 45)
    );

    /**
     * 부모 클래스의 인스턴스를 자식 클래스 타입으로 변환하기 위해서는
     * 명시적인 타입 캐스팅이 필요하다.
     * 이를 '다운캐스팅' 이라고 한다.
     */
    GradeLecture tobe = (GradeLecture) downCast;
  }
}
