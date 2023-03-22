package nl.avasten._INPROJAV.energieRekening;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EnergieRekening {

    double vasteKostenGas, vasteKostenStroom, variabeleKostenGas, variabeleKostenStroom;

    public EnergieRekening(double vasteKostenGas, double vasteKostenStroom, double variabeleKostenGas, double variabeleKostenStroom) {
        this.vasteKostenGas = vasteKostenGas;
        this.vasteKostenStroom = vasteKostenStroom;
        this.variabeleKostenGas = variabeleKostenGas;
        this.variabeleKostenStroom = variabeleKostenStroom;
    }

    public double BerekenJaarNota(int gasVerbruik, int stroomVerbruik, int stroomTeruggeleverd) {
        double jaarKosten = 0.00;
        int stroomSaldo = stroomVerbruik - stroomTeruggeleverd;

        jaarKosten += (this.vasteKostenGas * 12.00);
        jaarKosten += (this.vasteKostenStroom * 12.00);
        jaarKosten += (this.variabeleKostenGas * gasVerbruik);
        jaarKosten += (this.variabeleKostenStroom * stroomSaldo);

        return jaarKosten;
    }

    public BigDecimal BerekenJaarNotaBigDecimal(int gasVerbruik, int stroomVerbruik, int stroomTeruggeleverd) {

        BigDecimal jaarKosten = new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP);
        int stroomSaldo = stroomVerbruik - stroomTeruggeleverd;

        jaarKosten = jaarKosten.add(new BigDecimal(this.vasteKostenGas * 12.00));
        jaarKosten = jaarKosten.add(new BigDecimal(this.vasteKostenStroom * 12.00)).setScale(2, RoundingMode.HALF_UP);
        jaarKosten = jaarKosten.add(new BigDecimal(this.variabeleKostenGas * gasVerbruik)).setScale(2, RoundingMode.HALF_UP);
        jaarKosten = jaarKosten.add(new BigDecimal(this.variabeleKostenStroom * stroomSaldo)).setScale(2, RoundingMode.HALF_UP);

        return jaarKosten;
    }
}
