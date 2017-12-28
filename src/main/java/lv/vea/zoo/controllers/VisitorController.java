package lv.vea.zoo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import lv.vea.zoo.shop.dao.TicketRepository;
import lv.vea.zoo.shop.dao.VisitorRepository;
import lv.vea.zoo.shop.ticket.Ticket;
import lv.vea.zoo.shop.visitor.Visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private TicketController ticketController = new TicketController();
    
    @RequestMapping(value = "/allvisitors", method = RequestMethod.GET)
    public List<String> getAllVisitors() {
        List<Visitor> visitors = (List<Visitor>) visitorRepository.findAll();
        return visitors.stream().map(Visitor::getName).collect(Collectors.toList());
    }

    @RequestMapping(value = "/visitor", method = RequestMethod.POST)
    public ResponseEntity addVisitor(
            @RequestParam("name") final String name,
            @RequestParam("surname") final String surname, 
            @RequestParam("age") final int age) {
                visitorRepository.save(new Visitor(name, surname, age));
                return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/visitors", method = RequestMethod.GET)
    public List<Visitor> getAllVisitorsFullInfo() {
        List<Visitor> visitors = (List<Visitor>) visitorRepository.findAll();
        return visitors;
    }

	@RequestMapping(value = "/visitors/{id}", method = RequestMethod.GET )
	public Visitor getById(@PathVariable Long id){
		return visitorRepository.findOne(id);
    }
    
	@RequestMapping(value="/visitors/{id}/delete", method=RequestMethod.GET)
	public void deleteVisitor(@PathVariable Long id) {
		visitorRepository.delete(id);
    }
    
    @RequestMapping(value="/createvisitor/{name}/{surname}/{age}", method=RequestMethod.GET)
	public ResponseEntity createVisitor(
            @PathVariable("name") final String name,
            @PathVariable("surname") final String surname, 
            @PathVariable("age") final int age) {
                visitorRepository.save(new Visitor(name, surname, age));
                return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/visitors/{id}/addticket", method = RequestMethod.GET)
    public List<Ticket> getTickets() {   
            return ticketController.getAllTickets();
    }

    @RequestMapping(value = "/visitors/{id1}/addticket/{id2}", method = RequestMethod.GET)
    public void addTicket(
            @PathVariable("id1") final Long id1, 
            @PathVariable("id2") final Long id2) {
            Visitor temp = this.getById(id1);
            temp.addTicket(ticketController.getById(id2));
            visitorRepository.save(temp);  
    }
}
