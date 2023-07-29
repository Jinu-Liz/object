package books.chapter_01;

/**
 * getTicketOffice 메서드가 제거되어 TicketSeller만 TicketOffice에 접근할 수 있음
 */
public class TicketSeller {

  private TicketOffice ticketOffice;

  public TicketSeller(TicketOffice ticketOffice) {
    this.ticketOffice = ticketOffice;
  }

  public void sellTo(Audience audience) {
    this.ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
  }
}
