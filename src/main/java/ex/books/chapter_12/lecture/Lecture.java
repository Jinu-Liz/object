package ex.books.chapter_12.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

  private int pass;

  private String title;

  private List<Integer> scores = new ArrayList<>();

  public Lecture(String title, int pass, List<Integer> scores) {
    this.pass = pass;
    this.title = title;
    this.scores = scores;
  }

  public double average() {
    return scores.stream()
      .mapToInt(Integer::intValue)
      .average()
      .orElse(0);
  }

  public List<Integer> getScores() {
    return Collections.unmodifiableList(scores);
  }

  public String evaluate() {
    return String.format("Pass:%d Fail:%d", passCount(), failCount());
  }

  private long passCount() {
    return scores.stream()
      .filter(score -> score >= pass)
      .count();
  }

  /**
   * 1 Lecture 인스턴스가 stats 메세지를 수신
   * 2. 메세지를 수신한 Lecture 인스턴스를 가리키도록 self 참조 할당
   * 3. 해당 객체의 클래스인 Lecture에서 stats 메서드를 발견하고 실행
   * 4. 메서드 실행 중 getEvaluationMethod 메서드 호출 구문 발견, self 참조 객체에게 메세지 전송 판단
   * 5. self 참조가 가리키는 Lecture 클래스에서부터 메서드 재탐색 시작.
   * 6. Lecture의 getEvaluationMethod 메서드 실행 후, 탐색 종료.
   *
   * 여기서 중요한 것은 현재 클래스의 메서드를 호출하는 것이 아니라,
   * 현재 객체에게 메세지를 전송한다는 것이다.
   */
  public String stats() {
    return String.format("Title: %s, Evaluation Method: %s", title, getEvaluationMethod());
  }

  public String getEvaluationMethod() {
    return "Pass or Fail";
  }

  private long failCount() {
    return this.scores.size() - passCount();
  }

}
