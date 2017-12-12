package lv.vea.zoo.customer;

import java.util.LinkedList;
import java.util.List;

import lv.vea.zoo.ticket.Ticket;

public class Customer {

    private long id;

    private String name;

    private String surname;

    private int age;

    private List<Ticket> ticketsBought;

    private boolean activated;

    public Customer() {
        this.activated = true;
    }

    public Customer(final String name, final String surname, final int age) {
        this();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public List<Ticket> getTicketsBought() {
        if (ticketsBought == null) {
            ticketsBought = new LinkedList<>();
        }
        return ticketsBought;
    }

    public void setTicketsBought(final List<Ticket> ticketsBought) {
        this.ticketsBought = ticketsBought;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(final boolean activated) {
        this.activated = activated;
    }
}
