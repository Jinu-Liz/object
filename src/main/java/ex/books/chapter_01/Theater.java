package ex.books.chapter_01;

public class Theater {

  private TicketSeller ticketSeller;

  public Theater(TicketSeller ticketSeller) {
    this.ticketSeller = ticketSeller;
  }

  /**
   * 해당 메서드를 이해하기 위해서는
   * 1. Audience가 Bag을 가지고 있고
   * 2. Bag 안에는 현금과 티켓이 들어있으며
   * 3. TicketSeller가 TicketOffice에서 티켓을 판매하고
   * 4. TicketOffice 안에 돈과 티켓이 보관돼 있다는 사실을 전부 알고 있어야 한다.
   * 즉, 하나의 클래스 or 메서드가 너무 많은 세부사항을 다루고 있음.
   *
   * Theater은 관람객이 가방을 들고있고, 판매원이 매표소에서만 티켓을 판매한다는 가정 하에 동작한다.
   * 따라서 Audience가 가방을 들고있다는 가정이 변경되면 Theater도 변경해야 한다.
   * 즉, 의존성이 크다. (결합도가 높다.)
   *
   * 기존 enter의 로직을 ticketSeller로 이동시키면서 Theater은 TicketOffice의 존재를 알지 못한다.
   * 그저 TicketSeller의 sellTo 메서드를 사용하기만 한다.
   */
  public void enter(Audience audience) {
    this.ticketSeller.sellTo(audience);
  }
}
