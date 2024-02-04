package ex.books.chapter_11.composite;

import java.util.Hashtable;

/**
 * Hashtable을 Properties 클래스의 인스턴스 변수로 포함시키면서 상속 관계를 합성 관계로 변경.
 * 클라이언트는 Properties에서 정의한 오퍼레이션만 사용할 수 있으며, Hashtable의 오퍼레이션을
 * 사용할 수 없기 때문에 String 타입의 K,V만 허용하는 Properties의 규칙을 어길 위험성은 사라진다.
 *
 * 내부 구현에 밀접하게 결합되는 상속과 달리, Properties는 Hashtable의 내부 구현에 대해 알지 못하며,
 * 오직 get/set에 포함된 퍼블릭 인터페이스를 통해서만 Hashtable과 협력할 수 있다.
 */
public class Properties {

  private Hashtable<String, String> properties = new Hashtable<>();

  public String setProperty(String key, String value) {
    return properties.put(key, value);
  }

  public String getProperty(String key) {
    return properties.get(key);
  }

}
