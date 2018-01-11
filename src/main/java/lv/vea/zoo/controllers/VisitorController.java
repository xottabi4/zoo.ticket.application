package lv.vea.zoo.controllers;

import java.util.List;

import lv.vea.zoo.shop.Shop;
import lv.vea.zoo.shop.ticket.dto.Ticket;
import lv.vea.zoo.shop.visitor.dto.Visitor;
import lv.vea.zoo.shop.voucher.dto.Voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/visitor")
public class VisitorController {

    private Shop shop;

    @Autowired
    public VisitorController(final Shop shop) {
        this.shop = shop;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createNewVisitor(
            @RequestParam("name") final String name,
            @RequestParam("surname") final String surname,
            @RequestParam("age") final Long age) {
        shop.createNewVisitor(name, surname, age);
        return new ResponseEntity("Successfully created visitor", HttpStatus.OK);
    }

    @RequestMapping(value = "/create/{name}/{surname}/{age}", method = RequestMethod.GET)
    public ResponseEntity createNewVisitorUsingPathVariable(
            @PathVariable("name") final String name,
            @PathVariable("surname") final String surname,
            @PathVariable("age") final Long age) {
        shop.createNewVisitor(name, surname, age);
        return new ResponseEntity("Successfully created visitor", HttpStatus.OK);
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<Visitor> listAllVisitors() {
        return shop.getAllVisitors();
    }

    @RequestMapping(value = "/listAll/{id}", method = RequestMethod.GET)
    public Visitor listVisitor(@PathVariable("id") Long id) {
        return shop.getVisitor(id);
    }

    @RequestMapping(value = "/listAll/{id}/tickets", method = RequestMethod.GET)
    public List<Ticket> listVisitorTickets(@PathVariable("id") Long id) {
        return shop.getVisitor(id).getTicketsBought();
    }

    @RequestMapping(value = "/listAll/{id}/vouchers", method = RequestMethod.GET)
    public List<Voucher> listVisitorVouchers(@PathVariable("id") Long id) {
        return shop.getVisitor(id).getVouchers();
    }

    @RequestMapping(value = "/listAll/{id}/delete", method = RequestMethod.GET)
    public ResponseEntity deleteVisitor(@PathVariable("id") Long id) {
        shop.deleteVisitor(id);
        return new ResponseEntity("Successfully deleted visitor", HttpStatus.OK);
    }
}
