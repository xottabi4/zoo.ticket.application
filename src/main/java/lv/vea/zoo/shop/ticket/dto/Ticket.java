package lv.vea.zoo.shop.ticket.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lv.vea.zoo.shop.visitor.dto.Visitor;
import lv.vea.zoo.shop.voucher.dto.Voucher;

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
    private LocalDate dateBought;

    @Column(name = "dateUsed")
    private LocalDate dateUsed;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    @OneToOne
    @JoinColumn(name = "voucher_id", nullable = true)
    private Voucher voucher;

    public Ticket() {
        this.dateBought = LocalDate.now();
    }

    public Ticket(final String zone, final BigDecimal price, final Visitor visitor) {
        this();
        this.zone = zone;
        this.price = price;
        this.visitor = visitor;
    }

    public Ticket(final String zone, final BigDecimal price, final Visitor visitor,final Voucher voucher) {
        this();
        this.zone = zone;
        this.voucher=voucher;

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

    public LocalDate getDateBought() {
        return dateBought;
    }

    public LocalDate getDateUsed() {
        return dateUsed;
    }

    public void useTicket() {
        this.dateUsed = LocalDate.now();
    }


    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
