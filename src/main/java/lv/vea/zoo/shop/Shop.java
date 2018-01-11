package lv.vea.zoo.shop;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lv.vea.zoo.shop.ticket.TicketService;
import lv.vea.zoo.shop.ticket.dto.Ticket;
import lv.vea.zoo.shop.visitor.VisitorRepository;
import lv.vea.zoo.shop.visitor.dto.Visitor;
import lv.vea.zoo.shop.voucher.VoucherRepository;
import lv.vea.zoo.shop.voucher.dto.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Shop {

    private TicketService ticketService;

    private VisitorRepository visitorRepository;
    private VoucherRepository voucherRepository;

    @Autowired
    public Shop(final TicketService ticketService, 
                final VisitorRepository visitorRepository, 
                final VoucherRepository voucherRepository) {
        this.ticketService = ticketService;
        this.visitorRepository = visitorRepository;
        this.voucherRepository = voucherRepository;

    }

    public void sellTicket(final long customerId, final String ticketZone) {
        final Visitor visitor = visitorRepository.findOne(customerId);
        final Ticket ticket = ticketService.createNewTicket(ticketZone, visitor);
        visitor.getTicketsBought().add(ticket);
    }

    public void sellTicket(final long customerId, final String ticketZone, final long voucherId) {
        final Visitor visitor = visitorRepository.findOne(customerId);
        final Ticket ticket = ticketService.createNewTicket(ticketZone, visitor);
        visitor.getTicketsBought().add(ticket);
    }

    public void giveVoucher(final long customerId, final BigDecimal discount) {
        final Visitor visitor = visitorRepository.findOne(customerId);
        final Voucher voucher = voucherRepository.save(new Voucher(discount, visitor));
        visitor.getVouchers().add(voucher);
    }

    public void createVoucher(BigDecimal percentage){
        final Voucher voucher = new Voucher(percentage);
        voucherRepository.save(voucher);
    }

    public List<Voucher> getAllVouchers(){
        return (List<Voucher>) voucherRepository.findAll();
    }

    public Map<String,BigDecimal> getZoneBaseInfo(){
        return (Map<String, BigDecimal>) ticketService.getZoneBaseInfo();
    }

    public void createNewVisitor(final String name, final String surname, final Long age) {
        final Visitor visitor = new Visitor(name, surname, age);
        visitorRepository.save(visitor);
    }

    public List<Visitor> getAllVisitors() {
        return (List<Visitor>) visitorRepository.findAll();
    }

    public Visitor getVisitor(Long id){
        return (Visitor) visitorRepository.findOne(id);
    }

    public Voucher getVoucher(Long id){
        return (Voucher) voucherRepository.findOne(id);
    }

    public void deleteVisitor(Long id){
        visitorRepository.delete(id);
    }

    public void deleteVoucher(Long id){
        voucherRepository.delete(id);
    }

    public List<Ticket> getAllActiveTickets() {
        return ticketService.getAllActiveTickets();
    }
}
