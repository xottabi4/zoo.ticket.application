package lv.vea.zoo.shop.ticket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lv.vea.zoo.shop.dao.TicketRepository;
import lv.vea.zoo.shop.ticket.dto.Ticket;
import lv.vea.zoo.shop.visitor.dto.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private PriceStorage priceStorage;

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(final PriceStorage priceStorage, final TicketRepository ticketRepository) {
        this.priceStorage = priceStorage;
        this.ticketRepository = ticketRepository;
    }

    public Ticket createNewTicket(final String zone, final Visitor visitor) {
        final BigDecimal ticketBasePrice = priceStorage.determineTicketBasePrice(zone);
        final BigDecimal finalTicketPrice = priceStorage.discountPriceBasedOnAge(ticketBasePrice, visitor.getAge());
        final Ticket ticket = new Ticket(zone, finalTicketPrice, visitor);
        ticketRepository.save(ticket);
        return ticket;
    }

    public List<Ticket> getAllActiveTickets() {
        return ticketRepository.findAllActiveTickets(LocalDate.now());
    }
}
