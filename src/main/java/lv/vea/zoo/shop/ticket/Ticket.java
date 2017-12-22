package lv.vea.zoo.shop.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "zone")
    private String zone;

    @Column(name = "price")
    private String price;

    @Column(name = "expired")
    private Boolean expired;

    public Ticket() {
        this.expired = false;
    }

    public Ticket(final String zone, final String price) {
        this();
        this.zone = zone;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(final String price) {
        this.price = price;
    }

    public Boolean isExpired() {
        return expired;
    }

    public void setExpired(final Boolean expired) {
        this.expired = expired;
    }
}
