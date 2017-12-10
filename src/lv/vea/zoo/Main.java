package lv.vea.zoo;

public class Main {

    public static void main(String[] args) {
        TicketService ticketService = new TicketService(new PriceStorage());

        ticketService.createNewTicket("something");

    }
}
