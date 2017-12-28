package lv.vea.zoo.controllers;

import lv.vea.zoo.shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/sell", method = RequestMethod.POST)
    public ResponseEntity sellTIcket(
            @RequestParam("visitorId") final Long visitorId,
            @RequestParam("zone") final String zone) {
        shop.sellTicket(visitorId, zone);
        return new ResponseEntity(HttpStatus.OK);
    }
}
