package org.example.energieRekening;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnergieRekeningTest {

    @Test
    void berekenJaarNota() {
        EnergieRekening energieRekening = new EnergieRekening(19.44, 24.49, 2.37, 0.895);
        double verwachteJaarNota = 5996.95;
        assertEquals(verwachteJaarNota, energieRekening.BerekenJaarNota(1459, 3448, 1200), "Jaarnota niet gelijk");

    }

    @Test
    void givenAnEnergyBillWhen() {
        EnergieRekening energieRekening = new EnergieRekening(19.44, 24.49, 2.37, 0.895);
        BigDecimal verwachteJaarNota = new BigDecimal(5996.95).setScale(2, RoundingMode.HALF_UP);
        BigDecimal realisatieJaarNota = energieRekening.BerekenJaarNotaBigDecimal(1459, 3448, 1200);
        assertEquals(verwachteJaarNota, realisatieJaarNota, "Jaarnota bigdecimal niet gelijk");
    }
}