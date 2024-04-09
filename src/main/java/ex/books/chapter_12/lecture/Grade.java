package ex.books.chapter_12.lecture;

import lombok.Getter;

public class Grade {

  @Getter
  private String name;

  private int upper, lower;

  public Grade(String name, int upper, int lower) {
    this.name = name;
    this.upper = upper;
    this.lower = lower;
  }

  public boolean isName(String name) {
    return this.name.equals(name);
  }

  // 수강생 성적이 등급에 포함되는지 검사
  public boolean include(int score) {
    return score >= this.lower && score <= this.upper;
  }
}
