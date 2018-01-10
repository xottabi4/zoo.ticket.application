package lv.vea.zoo.shop;

import java.util.List;

import lv.vea.zoo.shop.ticket.TicketService;
import lv.vea.zoo.shop.ticket.dto.Ticket;
import lv.vea.zoo.shop.visitor.VisitorRepository;
import lv.vea.zoo.shop.visitor.dto.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Shop {

    private TicketService ticketService;

    private VisitorRepository visitorRepository;

    @Autowired
    public Shop(final TicketService ticketService, final VisitorRepository visitorRepository) {
        this.ticketService = ticketService;
        this.visitorRepository = visitorRepository;
    }

    public void sellTicket(final long customerId, final String ticketZone) {
        final Visitor visitor = visitorRepository.findOne(customerId);
        final Ticket ticket = ticketService.createNewTicket(ticketZone, visitor);
        visitor.getTicketsBought().add(ticket);
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

    public void deleteVisitor(Long id){
        visitorRepository.delete(id);
    }

    public List<Ticket> getAllActiveTickets() {
        return ticketService.getAllActiveTickets();
    }
}
