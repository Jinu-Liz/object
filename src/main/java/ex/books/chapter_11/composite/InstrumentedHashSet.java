package ex.books.chapter_11.composite;

import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet은 Set 인터페이스의 구현체 중 하나이므로,
 * InstrumentedHashSet이 Set 인터페이스를 실체화하면서 내부에 HashSet의 인스턴스를 합성하면
 * 구현 결합도는 제거하면서 퍼블릭 인터페이스는 그대로 유지할 수 있다.
 *
 * Set의 메서드를 오버라이딩한 메서드에서 내부의 HashSet 인스턴스에게 동일한 메서드 호출을 그대로 전달하고 있다.
 * 이를 포워딩(forwarding)이라 부르고, 동일한 메서드를 호출하기 위해 추가된 메서드를 포워딩 메서드(forwarding method)라고 부른다.
 * 기존 클래스의 인터페이스를 그대로 외부에 제공하면서, 구현에 대한 결합 없이 일부 작동 방식을 변경하고 싶은 경우 사용.
 */
public class InstrumentedHashSet<E> implements Set<E> {

  @Getter
  private int addCount = 0;

  private HashSet<E> set;

  public InstrumentedHashSet(HashSet<E> set) {
    this.set = set;
  }

  @Override
  public boolean add(E e) {
    this.addCount++;

    return this.set.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    this.addCount += c.size();

    return this.set.addAll(c);
  }

  @Override
  public int size() {
    return this.set.size();
  }

  @Override
  public boolean isEmpty() {
    return this.set.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return this.set.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return this.set.iterator();
  }

  @Override
  public Object[] toArray() {
    return this.set.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return this.set.toArray(a);
  }

  @Override
  public boolean remove(Object o) {
    return this.set.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return this.set.containsAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return this.set.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return this.set.removeAll(c);
  }

  @Override
  public void clear() {
    this.set.clear();
  }

}
