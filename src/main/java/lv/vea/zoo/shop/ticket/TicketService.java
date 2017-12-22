package lv.vea.zoo.shop.ticket;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private PriceStorage priceStorage;

    @Autowired
    public TicketService(final PriceStorage priceStorage) {
        this.priceStorage = priceStorage;
    }

    public Ticket createNewTicket(final String zone) {
        BigDecimal ticketBasePrice = priceStorage.determineTicketPrice(zone);
        final Ticket ticket = new Ticket(zone, ticketBasePrice.toPlainString());
        // here should go call to method, that saves ticket to DB
        return ticket;
    }


}
