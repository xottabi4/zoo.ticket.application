package lv.vea.zoo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import lv.vea.zoo.shop.dao.TicketRepository;
import lv.vea.zoo.shop.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Not done yet, used only for testing porpoises
@RestController
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public ResponseEntity addTicket(@RequestParam("zone") final String zone,
            @RequestParam("price") final String price) {
        ticketRepository.save(new Ticket(zone, price));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/alltickets", method = RequestMethod.GET)
    public List<String> getAllTicket() {
        List<Ticket> tickets = (List<Ticket>) ticketRepository.findAll();
        return tickets.stream().map(Ticket::getZone).collect(Collectors.toList());
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> getAllTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    @RequestMapping(value = "/createticket/{zone}/{price}", method = RequestMethod.GET)
    public ResponseEntity createTicket(
            @PathVariable("zone") final String zone,
            @PathVariable("price") final String price) {
        ticketRepository.save(new Ticket(zone, price));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/createtickets/{zone}/{price}/{amount}", method = RequestMethod.GET)
    public ResponseEntity createTickets(
            @PathVariable("zone") final String zone,
            @PathVariable("price") final String price,
            @PathVariable("amount") final int amount){
        for(int i = 0; i < amount; i++){
            ticketRepository.save(new Ticket(zone, price));
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET )
	public Ticket getById(@PathVariable Long id){
		return ticketRepository.findOne(id);
    }

    @RequestMapping(value="/tickets/{id}/delete", method=RequestMethod.GET)
	public String deleteTicket(@PathVariable Long id) {
        ticketRepository.delete(id);
        return "Deleted ticket with ID: " + id;
    }

    
}
