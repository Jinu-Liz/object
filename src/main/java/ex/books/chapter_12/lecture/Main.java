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
  }
}
