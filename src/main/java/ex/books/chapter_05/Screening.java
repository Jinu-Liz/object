package ex.books.chapter_05;

import ex.books.common.Money;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Screening {

  private Movie movie;

  private int sequence;

  private LocalDateTime whenScreened;

  public Reservation reserve(Customer customer, int audienceCount) {
    return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
  }

  private Money calculateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
  }

}
