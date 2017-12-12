package lv.vea.zoo.ticket;

import java.math.BigDecimal;

public class TicketService {

    private PriceStorage priceStorage;

    public TicketService(final PriceStorage priceStorage) {
        this.priceStorage = priceStorage;
    }

    public Ticket createNewTicket(final String zone) {
        BigDecimal ticketBasePrice = priceStorage.determineTicketPrice(zone);
        final Ticket ticket = new Ticket(zone, ticketBasePrice);
        // here should go call to method, that saves ticket to DB
        return ticket;
    }


}
