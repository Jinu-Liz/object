package ex.books.chapter_12.lecture;

import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {

  private List<Grade> grades;

  public GradeLecture(String name, int pass, List<Grade> grades, List<Integer> scores) {
    super(name, pass, scores);
    this.grades = grades;
  }

  /**
   * 부모와 자식에 동일한 시그니처를 가진 메서드의 경우,
   * 자식 클래스의 메서드가 실행된다. (메서드 오버라이딩)
   */
  @Override
  public String evaluate() {
    return super.evaluate() + ", " + gradesStatistics();
  }

  /**
   * 부모와 메서드명이 같으나, 시그니처가 다르므로
   * Lecture의 average 메서드를 대체하지 않는다. (메서드 오버로딩)
   */
  public double average(String gradeName) {
    return this.grades.stream()
      .filter(each -> each.isName(gradeName))
      .findFirst()
      .map(this::gradeAverage)
      .orElse(0d);
  }

  @Override
  public String getEvaluationMethod() {
    return "Grade";
  }

  private double gradeAverage(Grade grade) {
    return getScores().stream()
      .filter(grade::include)
      .mapToInt(Integer::intValue)
      .average()
      .orElse(0);
  }


  private String gradesStatistics() {
    return this.grades.stream()
      .map(this::format)
      .collect(Collectors.joining(" "));
  }

  private String format(Grade grade) {
    return String.format("%s:%d", grade.getName(), gradeCount(grade));
  }

  private long gradeCount(Grade grade) {
    return getScores().stream()
      .filter(grade::include)
      .count();
  }
}
