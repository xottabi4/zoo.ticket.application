package lv.vea.zoo.shop.voucher;

import java.math.BigDecimal;

public class Voucher {

    private long id;
    private BigDecimal discountPercentage;
    private boolean expired;

    public Voucher(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
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
