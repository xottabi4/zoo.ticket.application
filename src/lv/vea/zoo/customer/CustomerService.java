package lv.vea.zoo.customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    /**
     * This list with customers is for service demonstration porpoise only.
     * In real app queries should be performed to DB.
     */
    private static final List<Customer> customerList;

    static {
        customerList = new LinkedList<>();

        Customer customer1 = new Customer("name", "surname", 9);
        customer1.setId(1);
        customerList.add(customer1);
        Customer customer2 = new Customer("name2", "surname2", 18);
        customer2.setId(2);
        customerList.add(customer2);
    }

    public Customer getCustomerById(final long id) {
        //make query to database

        Optional<Customer> foundCustomer = customerList.stream()
                .filter(i -> id == i.getId()).findFirst();
        if (!foundCustomer.isPresent()) {
            throw new RuntimeException("Can't find customer with id: " + id);
        }
        return foundCustomer.get();
    }
}
