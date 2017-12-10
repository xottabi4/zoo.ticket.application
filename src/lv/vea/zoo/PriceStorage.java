package lv.vea.zoo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceStorage {

    private static final Map<String, BigDecimal> zoneBasePrices = createMap();

    private static Map<String, BigDecimal> createMap() {
        Map<String, BigDecimal> basePrices = new HashMap<String, BigDecimal>();
        basePrices.put("general", new BigDecimal("10"));
        basePrices.put("reptile house", new BigDecimal("7"));
        basePrices.put("butterfly (insect) house", new BigDecimal("8"));
        basePrices.put("petting zoo tickets", new BigDecimal("15"));
        return basePrices;
    }

    public BigDecimal determineTicketPrice(final String zone) {
        if (!zoneBasePrices.containsKey(zone)) {
            throw new RuntimeException("Such zone is not defined: " + zone);
        }
        return zoneBasePrices.get(zone);
    }

}
