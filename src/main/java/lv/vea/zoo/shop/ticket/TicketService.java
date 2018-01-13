package lv.vea.zoo.shop.ticket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import lv.vea.zoo.shop.dao.TicketRepository;
import lv.vea.zoo.shop.ticket.dto.Ticket;
import lv.vea.zoo.shop.visitor.dto.Visitor;
import lv.vea.zoo.shop.voucher.VoucherRepository;
import lv.vea.zoo.shop.voucher.dto.Voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private PriceStorage priceStorage;

    private TicketRepository ticketRepository;

    private VoucherRepository voucherRepository;

    @Autowired
    public TicketService(PriceStorage priceStorage, TicketRepository ticketRepository, VoucherRepository voucherRepository) {
        this.priceStorage = priceStorage;
        this.ticketRepository = ticketRepository;
        this.voucherRepository = voucherRepository;
    }

    public Map<String,BigDecimal> getZoneBaseInfo(){
        return priceStorage.getZoneBaseInfo();
    }

    public Ticket createNewTicket(final String zone, final Visitor visitor) {
        final BigDecimal ticketBasePrice = priceStorage.determineTicketBasePrice(zone);
        final BigDecimal finalTicketPrice = priceStorage.discountPriceBasedOnAge(ticketBasePrice, visitor.getAge());
        final Ticket ticket = new Ticket(zone, finalTicketPrice, visitor);
        ticketRepository.save(ticket);
        return ticket;
    }

    public Ticket createNewTicket(final String zone, final Visitor visitor, long voucherId) {
        final Voucher voucher = voucherRepository.findAvailableVouchers(voucherId);

        final BigDecimal ticketBasePrice = priceStorage.determineTicketBasePrice(zone);
        final BigDecimal agediscountedTicketPrice = priceStorage.discountPriceBasedOnAge(ticketBasePrice, visitor.getAge());
        final BigDecimal finalTicketPrice=PriceStorage.calculateDiscount(agediscountedTicketPrice,voucher.getDiscountPercentage());

        final Ticket ticket = new Ticket(zone, finalTicketPrice, visitor, voucher);
        ticketRepository.save(ticket);

        voucher.setExpired(true);
        voucherRepository.save(voucher);
        return ticket;
    }

    public List<Ticket> getAllActiveTickets() {
        return ticketRepository.findAllActiveTickets(LocalDate.now());
    }

    public void useTicket(Long ticketId) {
        Ticket ticket=ticketRepository.findOne(ticketId);
        ticket.useTicket();
        ticketRepository.save(ticket);
    }
}
