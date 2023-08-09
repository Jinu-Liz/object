package ex.books.chapter_04.example2;

public class Rectangle {

  private int left;

  private int top;

  private int right;

  private int bottom;

  public Rectangle(int left, int top, int right, int bottom) {
    this.left = left;
    this.top = top;
    this.right = right;
    this.bottom = bottom;
  }

  public int getLeft() {
    return left;
  }

  public int getTop() {
    return top;
  }

  public int getRight() {
    return right;
  }

  public int getBottom() {
    return bottom;
  }

  public void setLeft(int left) {
    this.left = left;
  }

  public void setTop(int top) {
    this.top = top;
  }

  public void setRight(int right) {
    this.right = right;
  }

  public void setBottom(int bottom) {
    this.bottom = bottom;
  }

  /**
   * Rectangle 내부에 로직을 캡슐화하여 자신의 크기를 스스로 증가시키도록
   * '책임을 이동'시켜 캡슐화를 강화시킨다.
   */
  public void enlarge(int multiple) {
    right *= multiple;
    bottom *= multiple;
  }
}
