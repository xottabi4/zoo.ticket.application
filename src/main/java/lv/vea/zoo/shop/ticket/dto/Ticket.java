package lv.vea.zoo.shop.ticket.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lv.vea.zoo.shop.visitor.dto.Visitor;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "zone")
    private String zone;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "dateBought")
    private LocalDateTime dateBought;

    @Column(name = "dateUsed")
    private LocalDateTime dateUsed;

    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    public Ticket() {
        this.dateBought = LocalDateTime.now();
    }

    public Ticket(final String zone, final BigDecimal price, final Visitor visitor) {
        this();
        this.zone = zone;
        this.price = price;
        this.visitor = visitor;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(final String zone) {
        this.zone = zone;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateBought() {
        return dateBought;
    }

    public LocalDateTime getDateUsed() {
        return dateUsed;
    }

    public void useTicket() {
        this.dateUsed = LocalDateTime.now();
    }
}
