package ex.books.chapter_01;

/**
 * Audience가 자신의 가방에서 초대장을 스스로 확인하도록 변경.
 * 외부의 제 3자가 자신의 가방을 열어보도록 허용하지 않는다.
 */
public class Audience {

  private Bag bag;

  public Audience(Bag bag) {
    this.bag = bag;
  }

  public Bag getBag() {
    return bag;
  }

  public Long buy(Ticket ticket) {
    Long fee = 0L;
    if (this.bag.hasInvitation()) {
      this.bag.setTicket(ticket);

    } else {
      this.bag.setTicket(ticket);
      this.bag.minusAmount(ticket.getFee());

      fee = ticket.getFee();
    }

    return fee;
  }

}
