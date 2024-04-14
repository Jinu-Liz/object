package ex.books.chapter_12.lecture;

import java.util.Arrays;

public class Main2 {
  public static void main(String[] args) {
    Lecture lecture = new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81, 95, 75, 50, 45));
    String evaluation = lecture.evaluate();
    System.out.println("evaluation = " + evaluation);

    GradeLecture gradeLecture = new GradeLecture(
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

    String gradeLectureEvaluate = gradeLecture.evaluate();
    System.out.println("gradeLectureEvaluate = " + gradeLectureEvaluate);

    /**
     * 같은 시그니처를 가진 메서드를 자식 클래스부터 탐색한다.
     * 못 찾는 경우, 부모 클래스로 점점 올라가면서 탐색한다.
     * 메서드 이름은 같지만, 시그니처에 따라 다른 기능을 하는 이유가 그것이다. (메서드 오버로딩)
     */
    double parentAverage = gradeLecture.average();
    double average = gradeLecture.average("A");
    System.out.println("parentAverage = " + parentAverage);
    System.out.println("average = " + average);
  }
}
