package ex.books.chapter_05;

/**
 * 클래스를 분리함으로써 모든 인스턴스 변수를 함께 초기화하고, 동일한 인스턴스 변수 그룹을 사용하게 됐다.
 * 결과적으로 개별 클래스들의 응집도가 향상되었다.
 */
public class SequenceCondition implements DCCondition {

  private int sequence;

  public SequenceCondition(int sequence) {
    this.sequence = sequence;
  }

  @Override
  public boolean isSatisfiedBy(Screening screening) {
    return sequence == screening.getSequence();
  }

}
