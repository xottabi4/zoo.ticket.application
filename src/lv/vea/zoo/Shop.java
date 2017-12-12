package lv.vea.zoo;

import lv.vea.zoo.customer.Customer;
import lv.vea.zoo.customer.CustomerService;
import lv.vea.zoo.ticket.Ticket;
import lv.vea.zoo.ticket.TicketService;

public class Shop {

    private TicketService ticketService;

    private CustomerService customerService;

    public Shop(final TicketService ticketService, final CustomerService customerService) {
        this.ticketService = ticketService;
        this.customerService = customerService;
    }

    public void sellTicket(final long customerId, final String ticketZone) {
        final Ticket ticket = ticketService.createNewTicket(ticketZone);
        final Customer customer = customerService.getCustomerById(customerId);
        customer.getTicketsBought().add(ticket);
    }
}
