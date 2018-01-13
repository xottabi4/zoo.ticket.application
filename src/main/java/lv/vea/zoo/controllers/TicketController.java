package lv.vea.zoo.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lv.vea.zoo.shop.Shop;
import lv.vea.zoo.shop.ticket.dto.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    private Shop shop;

    @Autowired
    public TicketController(final Shop shop) {
        this.shop = shop;
    }

    @RequestMapping(value = "/listZones", method = RequestMethod.GET)
    public Map<String, BigDecimal> getZoneBaseInfo(){
        return shop.getZoneBaseInfo();
    }

    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    public ResponseEntity sellTickets(
            @RequestParam("visitorId") final Long visitorId,
            @RequestParam("zone") final String zone) {
        shop.sellTicket(visitorId, zone);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/sell/{id}/{zone}", method = RequestMethod.GET)
    public ResponseEntity<String> sellTicketsUsingPathVariable(
            @PathVariable("id") final Long visitorId,
            @PathVariable("zone") final String zone) {
        shop.sellTicket(visitorId, zone);
        return new ResponseEntity<>("Ticket Sold",HttpStatus.OK);
    }

    @RequestMapping(value = "/sell/{id}/{zone}/usingVoucher/{voucherId}", method = RequestMethod.GET)
    public ResponseEntity<String> sellTicketsWithVoucherUsingPathVariable(
            @PathVariable("id") final Long visitorId,
            @PathVariable("zone") final String zone,
            @PathVariable("voucherId") final Long voucherId) {
        shop.sellTicket(visitorId, zone, voucherId);
        return new ResponseEntity<>("Ticket Sold",HttpStatus.OK);
    }

    @RequestMapping(value = "/use/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> useTicket(@PathVariable("id") final Long ticketId) {
        shop.useTicket(ticketId);
        return new ResponseEntity<>("Ticket used", HttpStatus.OK);
    }

    @RequestMapping(value = "/listAllActive", method = RequestMethod.GET)
    public List<Ticket> listAllActiveTickets() {
        return  shop.getAllActiveTickets();
    }
}
