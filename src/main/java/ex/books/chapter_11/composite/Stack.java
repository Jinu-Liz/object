package ex.books.chapter_11.composite;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Stack의 퍼블릭 인터페이스에 불필요한 Vector의 오퍼레이션들이 포함되지 않는다.
 * 클라이언트는 더이상 임의의 위치에 요소를 추가하거나 삭제할 수 없다.
 * 합성 관계로 변경함으로써 Stack을 잘못 사용할 수 있는 가능성을 제거한 것.
 */
public class Stack<E> {

  private Vector<E> elements = new Vector<>();

  public E push(E item) {
    elements.addElement(item);

    return item;
  }

  public E pop() {
    if (elements.isEmpty()) throw new EmptyStackException();

    return elements.remove(elements.size() - 1);
  }

}
