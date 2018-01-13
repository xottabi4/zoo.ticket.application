package lv.vea.zoo.shop.ticket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PriceStorage {

    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    private static final Map<String, BigDecimal> zoneBasePrices = createZoneBasePriceMap();

    private static final Map<String, BigDecimal> ageBasedDiscounts = createAgeBasedDiscountsMap();

    private static Map<String, BigDecimal> createZoneBasePriceMap() {
        Map<String, BigDecimal> basePrices = new HashMap<>();
        basePrices.put("general", new BigDecimal("10"));
        basePrices.put("reptile house", new BigDecimal("7"));
        basePrices.put("butterfly (insect) house", new BigDecimal("8"));
        basePrices.put("petting zoo tickets", new BigDecimal("15"));
        return basePrices;
    }

    private static Map<String, BigDecimal> createAgeBasedDiscountsMap() {
        Map<String, BigDecimal> ageDiscountMap = new HashMap<>();
        ageDiscountMap.put("pre-school-children", new BigDecimal("50"));
        ageDiscountMap.put("school-age-children", new BigDecimal("30"));
        ageDiscountMap.put("adults", new BigDecimal("0"));
        ageDiscountMap.put("seniors", new BigDecimal("50"));
        return ageDiscountMap;
    }

    public BigDecimal determineTicketBasePrice(final String zone) {
        if (!zoneBasePrices.containsKey(zone)) {
            throw new RuntimeException("Such zone is not defined: " + zone);
        }
        return zoneBasePrices.get(zone);
    }

    public static Map<String, BigDecimal> getZoneBaseInfo(){
        return zoneBasePrices;
    }

    public BigDecimal discountPriceBasedOnAge(final BigDecimal ticketBasePrice, final Long age) {
        final BigDecimal discountPrecentage;
        if (age < 6) {
            discountPrecentage = ageBasedDiscounts.get("pre-school-children");
        } else if (age >= 6 && age < 18) {
            discountPrecentage = ageBasedDiscounts.get("school-age-children");
        } else if (age >= 18 && age < 65) {
            discountPrecentage = ageBasedDiscounts.get("adults");
        } else {
            //age >= 65
            discountPrecentage = ageBasedDiscounts.get("seniors");
        }
        final BigDecimal discount = calculateDiscount(ticketBasePrice, discountPrecentage);
        return ticketBasePrice.subtract(discount);
    }

    public static BigDecimal calculateDiscount(BigDecimal base, BigDecimal pct) {
        return base.multiply(pct).divide(ONE_HUNDRED);
    }
}
