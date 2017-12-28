package lv.vea.zoo.controllers;

import java.util.List;

import lv.vea.zoo.shop.Shop;
import lv.vea.zoo.shop.visitor.dto.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<Visitor> listAllVisitors() {
        return shop.getAllVisitors();
    }
}
