package lv.vea.zoo.shop.ticket;

import java.math.BigDecimal;

public class Ticket {

    private long id;

    private String zone;

    private BigDecimal price;

    private boolean expired;

    public Ticket(final String zone, final BigDecimal price) {
        this.zone = zone;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
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

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(final boolean expired) {
        this.expired = expired;
    }
}
