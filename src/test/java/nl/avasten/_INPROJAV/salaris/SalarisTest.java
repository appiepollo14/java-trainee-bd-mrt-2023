package nl.avasten._INPROJAV.salaris;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalarisTest {

    @Test
    void indexeerSalaris() {

        Salaris salarisAsjer = new Salaris();
        salarisAsjer.indexeerSalaris(8.42);
        double expectedSalary = 3366.44;
        assertEquals(expectedSalary, salarisAsjer.getSalarisBedrag(), "Verschil in geindiceerd salaris!");

    }
}