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
    if (audience.getBag().hasInvitation()) {
      Ticket ticket = this.ticketOffice.getTicket();
      audience.getBag().setTicket(ticket);

    } else {
      Ticket ticket = this.ticketOffice.getTicket();
      audience.getBag().minusAmount(ticket.getFee());
      this.ticketOffice.plusAmount(ticket.getFee());
      audience.getBag().setTicket(ticket);

    }
  }
}
