package lv.vea.zoo.shop.visitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    /**
     * This list with customers is for service demonstration porpoise only.
     * In real app queries should be performed to DB.
     */
    private static final List<Visitor> VISITOR_LIST;

    static {
        VISITOR_LIST = new LinkedList<>();

        Visitor visitor1 = new Visitor("name", "surname", 9);
        visitor1.setId(1);
        VISITOR_LIST.add(visitor1);
        Visitor visitor2 = new Visitor("name2", "surname2", 18);
        visitor2.setId(2);
        VISITOR_LIST.add(visitor2);
    }

    public Visitor getCustomerById(final long id) {
        //make query to database

        Optional<Visitor> foundCustomer = VISITOR_LIST.stream()
                .filter(i -> id == i.getId()).findFirst();
        if (!foundCustomer.isPresent()) {
            throw new RuntimeException("Can't find visitor with id: " + id);
        }
        return foundCustomer.get();
    }
}
