package ex.books.chapter_13.movie;

import ex.books.common.Money;

import java.time.LocalDateTime;

public class Screening {

  private Movie movie;

  private LocalDateTime whenScreened;

  public Screening(Movie movie, LocalDateTime whenScreened) {
    this.movie = movie;
    this.whenScreened = whenScreened;
  }

  public LocalDateTime getStartTime() {
    return this.whenScreened;
  }

  public Money getMovieFee() {
    return this.movie.getFee();
  }

}
