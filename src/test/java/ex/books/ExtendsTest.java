package ex.books;

import ex.books.chapter_10.InstrumentedHashSet;
import ex.books.chapter_10.InstrumentedHashSet2;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Properties;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendsTest {

  @Test
  void stackTest() {
    Stack<String> stack = new Stack<>();
    stack.push("1st");
    stack.push("2nd");
    stack.push("3rd");

    // Stack의 부모인 Vector의 add 메서드를 이용하여 Stack의 맨 앞에 '4th' 추가
    stack.add(0, "4th");

    assertEquals("4th", stack.pop());   // 에러
  }

  @Test
  void propertiesTest() {
    Properties properties = new Properties();
    properties.setProperty("Bjarne Stroustrup", "C++");
    properties.setProperty("James Gosling", "Java");

    // Properties의 부모인 Hashtable의 put 메서드를 이용하여 String이 아닌 int값 저장
    properties.put("Dennis Ritchie", 67);

    // getProperty는 반환값의 타입이 String이 아닐 경우, null을 반환하도록 구현되어있음.
    assertEquals("C", properties.getProperty("Dennis Ritchie"));  // 에러
  }

  @Test
  void hashsetTest() {
    // addAll에서 add를 호출하기 때문에, addCount의 값이 3이 아니라 6이 됨.
    InstrumentedHashSet<String> languages = new InstrumentedHashSet<>();
    languages.addAll(Arrays.asList("Java", "Ruby", "Scala"));

    InstrumentedHashSet2<String> languages2 = new InstrumentedHashSet2<>();
    languages2.addAll(Arrays.asList("Java", "Ruby", "Scala"));
  }
}
