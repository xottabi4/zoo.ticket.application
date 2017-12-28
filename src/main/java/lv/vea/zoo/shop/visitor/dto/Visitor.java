package lv.vea.zoo.shop.visitor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

import lv.vea.zoo.shop.ticket.dto.Ticket;

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
    private Long age;

    @Column(name = "ticketsBought")
    @OneToMany(mappedBy = "visitor")
    private List<Ticket> ticketsBought;

    @Column(name = "activated")
    private Boolean activated;

    public Visitor() {
        this.activated = true;
    }

    public Visitor(final String name, final String surname, final Long age) {
        this();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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

    public Long getAge() {
        return age;
    }

    public void setAge(final Long age) {
        this.age = age;
    }

    public Boolean getActivated() {
        return activated;
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

    public Boolean isActivated() {
        return activated;
    }

    public void setActivated(final Boolean activated) {
        this.activated = activated;
    }


}
