package lv.vea.zoo;

import lv.vea.zoo.customer.Customer;
import lv.vea.zoo.customer.CustomerService;
import lv.vea.zoo.ticket.PriceStorage;
import lv.vea.zoo.ticket.TicketService;

public class Main {

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Shop shop = new Shop(new TicketService(new PriceStorage()), customerService);

        //verify that customer has no tickets
        Customer customer = customerService.getCustomerById(1);
        System.out.println(customer.getTicketsBought().size());

        shop.sellTicket(1, "general");

        //verify that customer received ticket
        System.out.println(customer.getTicketsBought().size());
    }
}
