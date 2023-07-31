package ex.books.chapter_02;

public class SequenceContidion implements DiscountCondition {

  private int sequence;

  public SequenceContidion(int sequence) {
    this.sequence = sequence;
  }

  @Override
  public boolean isSatisfiedBy(Screening screening) {
    return screening.isSequence(sequence);
  }

}
