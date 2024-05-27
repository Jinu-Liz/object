package ex.books.chapter_12.lecture;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {

  public FormattedGradeLecture(String name, int pass, List<Grade> grades, List<Integer> scores) {
    super(name, pass, grades, scores);
  }

  /**
   * 단순히 부모 클래스의 메서드를 호출하는 것이 아니라,
   * 더 상위에 위치한 조상 클래스의 메서드일 수도 있다.
   *
   * 만약, 부모 클래스의 메서드를 호출하는 것이라면 이 메서드는 정상적으로 실행될 수 없다.
   * GradeLecture에는 average() 메서드가 없기 때문이다. ( average(String gradeName)는 있지만 )
   * 하지만 이 메서드는 정상적으로 실행된다.
   * 실행되는 메서드는 GradeLecture의 부모클래스인 Lecture의 average() 메서드이다.
   *
   * 이는 부모클래스의 메서드를 호출하는 것이 아닌, '부모 클래스에서 메서드 탐색을 시작한다'는 것을 의미하며,
   * 그 클래스의 조상 어딘가에 해당 메서드가 정의되어 있기만 하면 실행할 수 있다는 것을 의미한다.
   */
  public String formatAverage() {
    return String.format("Avg: %1.1f", super.average());
  }
}
