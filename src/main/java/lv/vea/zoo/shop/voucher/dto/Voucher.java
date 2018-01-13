package lv.vea.zoo.shop.voucher.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lv.vea.zoo.shop.visitor.dto.Visitor;

@Entity
@Table(name = "voucher")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "discountPercentage")
    private BigDecimal discountPercentage;

    @Column(name = "expired")
    private boolean expired;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "visitor_id", nullable = false)
    private Visitor visitor;

    public Voucher() {
        this.expired = false;
    }

    public Voucher(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Voucher(BigDecimal discountPercentage, final Visitor visitor) {
        this.discountPercentage = discountPercentage;
        this.visitor = visitor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}
