package ex.books.chapter_10;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet2<E> extends HashSet<E> {

  private int addCount = 0;

  @Override
  public boolean add(E e) {
    this.addCount++;

    System.out.println("addCount2 = " + addCount);
    return super.add(e);
  }

  /**
   * 미래의 수정까지 고려하여 각 요소에 대해 한 번씩 add 메서드를 호출하도록 수정.
   * addAll 메서드가 add 메시지를 전송하지 않도록 수정되더라도 InstrumentedHashSet2의 행동에는 아무 영향도 없을 것이다.
   * 그러나 이는 HashSet의 것과 동일하며, 미래의 위험을 방지하기 위해 코드를 중복시킨 것이다.
   * 이러한 방법은 소스코드에 대한 접근 권한이 없을 수도 있고, 부모 클래스에서 private을 사용하고 있을 수도 있기 때문에
   * 항상 가능한 방법은 아니다.
   */
  @Override
  public boolean addAll(Collection<? extends E> c) {
    boolean modified = false;
    for (E e : c) {
      if (add(e)) modified = true;
    }

    return modified;
  }
}
