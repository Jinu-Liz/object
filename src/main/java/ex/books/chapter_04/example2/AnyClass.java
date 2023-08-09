package ex.books.chapter_04.example2;

/**
 * 해당 코드에는 문제점들이 있는데
 * 첫 번째로 '코드 중복'이 발생할 확률이 높다.
 * 다른 곳에서도 같은 기능이 필요하다면 그곳에서도 유사한 코드가 존재할 확률이 높다.
 * 두 번째로 '변경에 취약'하다.
 * right와 bottom 대신 length와 height를 이용하여 사각형을 표현하도록 수정한다고하면
 * getter/setter를 변경해야하고, 이를 사용하고 있는 모든 곳에 영향을 끼치게 된다.
 */
public class AnyClass {

  /**
   * Rectangle의 너비와 높이를 증가시키는 코드
   */
  void anyMethod(Rectangle rectangle, int multiple) {
    rectangle.setLeft(rectangle.getLeft() * multiple);
    rectangle.setRight(rectangle.getRight() * multiple);
    rectangle.setTop(rectangle.getTop() * multiple);
    rectangle.setBottom(rectangle.getBottom() * multiple);
  }

}
