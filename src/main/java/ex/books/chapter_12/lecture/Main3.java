package ex.books.chapter_12.lecture;

import java.util.Arrays;

public class Main3 {
  public static void main(String[] args) {
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

    /**
     * 1 GradeLecture에 stats 메세지를 전송
     * 2. self 참조가 GradeLecture 인스턴스를 가리키며, 메서드 탐색 시작
     * 3. 해당 객체에 stats 메서드가 없으므로 Lecture에서 stats 메서드를 발견하고 실행
     * 4. 메서드 실행 중 getEvaluationMethod 메서드 호출 구문 발견, self 참조 객체에게 메세지 전송 판단
     * 5. self 참조가 가리키는 GradeLecture 클래스에서부터 메서드 재탐색 시작.
     * 6. GradeLecture의 getEvaluationMethod 메서드 실행 후, 탐색 종료.
     */
    gradeLecture.stats();

  }
}
