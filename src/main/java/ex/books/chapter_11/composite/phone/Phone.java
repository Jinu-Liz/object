package ex.books.chapter_11.composite.phone;

import ex.books.chapter_11.composite.phone.policy.RatePolicy;
import ex.books.chapter_11.phone.Call;
import ex.books.common.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

  private RatePolicy ratePolicy;

  private List<Call> calls = new ArrayList<>();

  public Phone(RatePolicy ratePolicy) {
    this.ratePolicy = ratePolicy;
  }

  public List<Call> getCalls() {
    return Collections.unmodifiableList(calls);
  }

  public Money calculateFee() {
    return this.ratePolicy.calculateFee(this);
  }
}
