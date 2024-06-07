package ex.books.chapter_13.liskov;

import lombok.Data;

@Data
public class Rectangle {

  private int x;

  private int y;

  private int width;

  private int height;

  public Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public int getArea() {
    return this.width * this.height;
  }

}
