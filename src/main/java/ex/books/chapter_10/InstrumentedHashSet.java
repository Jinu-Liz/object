package ex.books.chapter_10;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {

  private int addCount = 0;

  @Override
  public boolean add(E e) {
    this.addCount++;

    System.out.println("addCount = " + addCount);
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    this.addCount += c.size();

    return super.addAll(c);   // addAll 내부에서 add를 호출한다.
  }
}
