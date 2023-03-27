package nl.avasten.H7.webshop;

import java.util.ArrayList;

public class CatalogueManager {

    private ArrayList<Catalogue> catalogues;

    public CatalogueManager() {
        this.catalogues = new ArrayList<>();
    }

    public void addCatalogue(Catalogue catalogue) {
        this.catalogues.add(catalogue);
    }

    public Catalogue getCatalogueForYear(int year) throws IllegalArgumentException {
        return this.catalogues
                .stream()
                .filter(m -> m.getYear() == (year))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
