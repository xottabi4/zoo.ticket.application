package lv.vea.zoo;

import java.math.BigDecimal;

public class TicketService {

    private PriceStorage priceStorage;

    public TicketService(final PriceStorage priceStorage) {
        this.priceStorage = priceStorage;
    }

    public Ticket createNewTicket(final String zone) {
        BigDecimal ticketBasePrice = priceStorage.determineTicketPrice(zone);
        Ticket ticket = new Ticket(zone, ticketBasePrice);
        // here goes call to method that saves ticket to DB
        return ticket;
    }


}
