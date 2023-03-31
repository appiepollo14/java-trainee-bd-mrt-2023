package nl.avasten.H7.webshop;

import java.util.ArrayList;
import java.util.UUID;

public class CatalogueManager {

  private static final CatalogueManager catalogueManager = new CatalogueManager();
  private ArrayList<Catalogue> catalogues;

  // Make this hidden for others
  private CatalogueManager() {
    this.catalogues = new ArrayList<>();
  }

  public static CatalogueManager getCatalogueManager() {
    return catalogueManager;
  }

  public void addCatalogue(Catalogue catalogue) {
    this.catalogues.add(catalogue);
  }

  public Catalogue getCatalogueForYear(int year) throws IllegalArgumentException {
    return this.catalogues.stream()
        .filter(m -> m.getYear() == (year))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public Item findObjectByUUID(UUID uuid) {
    return catalogues.stream()
        .flatMap(obj -> obj.getItems().stream().filter(innerObj -> innerObj.getId().equals(uuid)))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Object with UUID " + uuid + " not found"));
  }
}
