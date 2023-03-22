package nl.avasten._INPROJAV.salaris;

public class Salaris {

    private double salarisBedrag;

    public Salaris() {
        this.salarisBedrag = 3105.00;
    }

    public double getSalarisBedrag() {
        return salarisBedrag;
    }

    public void setSalarisBedrag(double nieuwSalarisBedrag) {
        this.salarisBedrag = nieuwSalarisBedrag;
    }

    public void indexeerSalaris(double indexatiePercentage) {

        double huidigSalaris = this.getSalarisBedrag();
        double nieuwSalaris = Math.round(huidigSalaris * (100.00 + indexatiePercentage)) / 100.00;
        this.setSalarisBedrag(nieuwSalaris);

        // TODO is onderstaand mooier?
        //this.salarisBedrag = Math.round(this.salarisBedrag * (100.00 + indexatiePercentage)) / 100.00;
    }


}
