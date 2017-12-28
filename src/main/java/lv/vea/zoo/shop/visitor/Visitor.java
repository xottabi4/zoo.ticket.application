 package lv.vea.zoo.shop.visitor;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lv.vea.zoo.shop.ticket.Ticket;

@Entity
@Table(name = "visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    //@Column(name = "tickets")
    //private List<Ticket> ticketsBought;

    @Column(name = "activated")
    private boolean activated;

    public Visitor() {
        this.activated = true;
    }

    public Visitor(final String name, final String surname, final int age) {
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
        //if (ticketsBought == null) {
        //    ticketsBought = new LinkedList<Ticket>();
        //}
        //return ticketsBought;
        return new LinkedList<Ticket>();
    }
    

    public void setTicketsBought(final List<Ticket> ticketsBought) {
        //this.ticketsBought = ticketsBought;
    }
    

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(final boolean activated) {
        this.activated = activated;
    }
}
