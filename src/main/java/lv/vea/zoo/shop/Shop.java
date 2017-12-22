package lv.vea.zoo.shop;

import lv.vea.zoo.shop.visitor.Visitor;
import lv.vea.zoo.shop.visitor.VisitorService;
import lv.vea.zoo.shop.ticket.Ticket;
import lv.vea.zoo.shop.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

public class Shop {

    private TicketService ticketService;

    private VisitorService visitorService;

    @Autowired
    public Shop(final TicketService ticketService, final VisitorService visitorService) {
        this.ticketService = ticketService;
        this.visitorService = visitorService;
    }

    public void sellTicket(final long customerId, final String ticketZone) {
        final Ticket ticket = ticketService.createNewTicket(ticketZone);
        final Visitor visitor = visitorService.getCustomerById(customerId);
        visitor.getTicketsBought().add(ticket);
    }
}
