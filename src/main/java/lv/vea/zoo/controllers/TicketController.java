package lv.vea.zoo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import lv.vea.zoo.shop.dao.TicketRepository;
import lv.vea.zoo.shop.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO: Not done yet, used only for testing porpoises
@RestController
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
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
}
