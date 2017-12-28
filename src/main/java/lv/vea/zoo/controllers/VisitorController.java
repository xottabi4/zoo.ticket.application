package lv.vea.zoo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import lv.vea.zoo.shop.dao.VisitorRepository;
import lv.vea.zoo.shop.visitor.Visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;
    
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
}
