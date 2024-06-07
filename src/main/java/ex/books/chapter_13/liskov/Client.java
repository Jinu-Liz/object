package ex.books.chapter_13.liskov;

public class Client {
  public static void main(String[] args) {
    Square square = new Square(10, 10, 10);
    resize(square, 50, 100);
    System.out.println(square);
  }

  /**
   * 직사각형은 너비와 높이가 다를 수 있다고 가정하지만,
   * 정사각형은 항상 동일하다고 가정한다.
   * resize 메서드는 Rectangle이 세운 가정에 기반하기 때문에
   * 직사각형의 너비와 높이를 독립적으로 변경할 수 있다고 가정한다.
   * 그러나 Square을 전달할 경우,이 가정은 무너지고 만다.
   *
   * Square는 Rectangle의 구현을 재사용하고 있을 뿐이다.
   * 이는 리스코프 치환 원칙을 위반하기 때문에 서브타이핑 관계가 아니라 서브클래싱 관계다.
   */
  public static void resize(Rectangle rectangle, int width, int height) {
    rectangle.setWidth(width);
    rectangle.setHeight(height);
    assert rectangle.getWidth() == width && rectangle.getHeight() == height;
  }
}
