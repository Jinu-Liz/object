package ex.books.chapter_11.composite.phone.policy;

import ex.books.chapter_11.composite.phone.Phone;
import ex.books.common.Money;

public interface RatePolicy {

  Money calculateFee(Phone phone);

}
