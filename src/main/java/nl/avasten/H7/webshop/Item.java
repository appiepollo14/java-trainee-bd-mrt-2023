package nl.avasten.H7.webshop;

import java.math.BigDecimal;
import java.util.UUID;

public record Item(UUID id, BigDecimal itemPrice, String description) {

    public Item(BigDecimal itemPrice, String description) {
        this(UUID.randomUUID(), itemPrice, description);
    }

}
